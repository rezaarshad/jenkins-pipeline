# jenkins-pipeline  
jenkins shared library example for maven based prject

## Plugins (which need to be installed)

https://plugins.jenkins.io/http_request  
https://plugins.jenkins.io/ssh-agent  
https://plugins.jenkins.io/email-ext  
https://plugins.jenkins.io/maven-plugin  
https://plugins.jenkins.io/pipeline-maven

## sample:

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
