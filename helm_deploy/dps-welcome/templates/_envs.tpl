{{/* vim: set filetype=mustache: */}}
{{/*
Environment variables for web and worker containers
*/}}
{{- define "deployment.envs" }}
env:
  - name: APPINSIGHTS_INSTRUMENTATIONKEY
    valueFrom:
      secretKeyRef:
        name: {{ template "app.name" . }}
        key: APPINSIGHTS_INSTRUMENTATIONKEY

  - name: APP_SERVICES_PNOMIS_URL
    value: {{ .Values.env.APP_SERVICES_PNOMIS_URL | quote }}

  - name: APP_SERVICES_DPS_HOME_URL
    value: {{ .Values.env.APP_SERVICES_DPS_HOME_URL | quote }}
{{- end -}}
