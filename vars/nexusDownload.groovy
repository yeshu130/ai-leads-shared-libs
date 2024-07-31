def call(artifactId,repoName,groupId,version){
    withCredentials([usernameColonPassword(credentialsId: 'nexus3', variable: 'nexusCreds')]) {
        sh "curl -u ${nexusCreds} -o ${artifactId}.war 'http://172.31.29.0:8081/service/rest/v1/search/assets/download?repository=${repoName}&group=${groupId}&name=${artifactId}&version=${version}&ext=war'"
    }
}
