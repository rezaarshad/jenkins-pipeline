def call(Map params) {

    pipeline {
        agent any
        stages {
            stage('Clone the project') {
                steps {
                  git branch: params.branch, url: params.gitUrl
                }
            }

            stage('Compilation') {
                steps {
                    script {
                        withMaven(maven: 'MVN3') {
                            sh "mvn clean package -DskipTests"
                        }
                    }
                }
            }

            stage('Tests') {
                steps {
                    parallel(
                            "unit tests": {
                                script {
                                    withMaven(maven: 'MVN3') {
                                        sh "mvn test"
                                    }
                                }
                            },
                            "integration tests": {
                                script {
                                    withMaven(maven: 'MVN3') {
                                        sh 'mvn integration-test'
                                    }
                                }
                            }
                    )
                }
            }

            stage('deploy development') {
                steps {
                    script {
                        if (params.deployInDev) {
                            deploy(params.deployType, params.type, params.developmentServer, params.serverPort, params.appName+'-dev')
                        }
                    }
                }
            }

            stage('deploy staging') {
                steps {
                    script {
                        if (params.deployInStage) {
                            deploy(params.deployType, params.type, params.stagingServer, params.serverPort, params.appName+'-stage')
                        }
                    }
                }
            }

            stage('deploy production') {
                steps {
                    script {
                        if (params.deployInProduction) {
                            deploy(params.deployType, params.type, params.productionServer, params.serverPort, params.appName+'-production')
                        }
                    }
                }
            }
        }
    }
}


return this
