# Jenkins Pipeline Shared Library

This repository provides an example of deploying Maven-based projects using Jenkins.

## Required Plugins

- [HTTP Request](https://plugins.jenkins.io/http_request)  
- [SSH Agent](https://plugins.jenkins.io/ssh-agent)  
- [Email Extension](https://plugins.jenkins.io/email-ext)  
- [Maven Plugin](https://plugins.jenkins.io/maven-plugin)  
- [Pipeline Maven Integration](https://plugins.jenkins.io/pipeline-maven)

## How to Import and Use the Library

To import and use this shared library in your Jenkins pipeline:

```groovy
@Library('jenkins-pipeline') _

MvnPipeline(
  branch: 'master',
  gitUrl: 'git url',
  type: 'mvn',
  deployType: '',
  email: '',
  serverPort: '8080',
  developmentServer: 'server1',
  stagingServer: 'server2',
  productionServer: 'server3',
  appName: '',
  deployInDev: true,
  deployInStage: false,
  deployInProduction: false
)
