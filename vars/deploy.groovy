def call(def deployType, def type, def server, def port, def appName) {
    switch (deployType) {
        case 'docker': deployDocker(server, port, appName)
        default: deploy(type, server, port, appName)
    }
}

def deploy(def type, def server, def port, def appName) {
    if (type == 'mvn') {
        httpRequest httpMode: 'POST', url: "http://${server}:${port}/shutdown", validResponseCodes: '200,408'
        sshagent(['RemoteCredentials']) {
            sh "scp target/*.jar root@${server}:/opt/${appName}.jar"
            sh "ssh root@${server} nohup java -Dserver.port=${port} -jar /opt/${appName}.jar &"
        }
        retry(3) {
            sleep 5
            httpRequest url: "http://${server}:${port}/health", validResponseCodes: '200', validResponseContent: '"status":"UP"'
        }
    }
}

def deployDocker(def server, def port, def appName) {

}
