
### Example deploy command
```
helm --namespace dps-welcome-dev  --tiller-namespace dps-welcome-dev upgrade dps-welcome ./dps-welcome/ --install --values=values-dev.yaml --values=example-secrets.yaml
```

### Helm init

```
helm init --tiller-namespace dps-welcome-dev --service-account tiller --history-max 200
```

### Setup Lets Encrypt cert

```
kubectl -n dps-welcome-dev apply -f certificate-dev.yaml
kubectl -n dps-welcome-prod apply -f certificate-prod.yaml
```
