def call(repoName,artifactId,groupId){
    def pom = readMavenPom file: 'pom.xml'
    def version = pom.version
    nexusArtifactUploader artifacts: [[artifactId: artifactId, classifier: '', file: "target/${artifactId}.war", type: 'war']], 
                            credentialsId: 'nexus3', 
                            groupId: groupId, 
                            nexusUrl: '172.31.11.195:8081', 
                            nexusVersion: 'nexus3', 
                            protocol: 'http', 
                            repository: repoName, 
                            version: version
}