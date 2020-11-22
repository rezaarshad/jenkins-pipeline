# jenkins pipeline shared library 
This repository is an example for deploying maven based projects using Jenkins.

## Plugins (need to be installed on Jenkins)

https://plugins.jenkins.io/http_request  
https://plugins.jenkins.io/ssh-agent  
https://plugins.jenkins.io/email-ext  
https://plugins.jenkins.io/maven-plugin  
https://plugins.jenkins.io/pipeline-maven

## How to run:

@Library(jenkins-pipeline) _  
MvnPipeline(branch: 'master',  
gitUrl: 'git url',  
type: 'mvn',  
deployType: '',  
email: '',  
serverPort: '8080',  
developmentServer: 'server1',  
stagingServer: 'server2',  
productionServer: 'server3',  
appName: '',  
deployInDev:true,  
deployInStage:false,  
deployInProduction:false)  
