
### Example deploy command
```
helm --namespace dps-welcome-dev  --tiller-namespace dps-welcome-dev upgrade dps-welcome ./dps-welcome/ --install --values=values-dev.yaml --values=example-secrets.yaml
```

### Rolling back a release with helm
Find the release revision number:
```
helm --tiller-namespace dps-welcome-dev history dps-welcome
```
(note, each revision's description has the app version in it to help easily find the revision)

Rollback
```
helm --tiller-namespace dps-welcome-dev rollback dps-welcome [INSERT REVISION NUMBER HERE] --wait
```

### Rolling back a release with circleci

Make sure you have a CIRCLECI_TOKEN, set one up on user settings in the circleci console.
```
export CIRCLECI_TOKEN=xxxx
```

Run the following API request, modify the parameters:
```
curl -u ${CIRCLECI_TOKEN}: -X POST --header "Content-Type: application/json" -d '{
  "parameters": {
    "deploy_app_version": "2019-08-05.50",
    "skip_build": true,
    "deploy_dev": true,
    "deploy_prod": false
  },
  "branch": "master"
}' https://circleci.com/api/v2/project/github/ministryofjustice/dps-welcome/pipeline
```
(Note: branch is optional, defaults to master branch)

Using this method does pose some problems, the helm chart version may not match the app version being deployed.  So some care needs to be taken to ensure that no missing or unexpected config/parameters are in `/helm_deploy`.  E.g. the above will take the latest master branch - which contains the latest revision of the `/helm_deploy` directory.  As of writing circleci API v2 does not support specifying a commit ID. If you need to deploy a really old version where you know the Chart config is different - you could create a branch using an older commit.


### Helm init

```
helm init --tiller-namespace dps-welcome-dev --service-account tiller --history-max 200
```

### Setup Lets Encrypt cert

```
kubectl -n dps-welcome-dev apply -f certificate-dev.yaml
kubectl -n dps-welcome-prod apply -f certificate-prod.yaml
```
