# jenkins-pipeline
jenkins shared library example for maven based prject


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
