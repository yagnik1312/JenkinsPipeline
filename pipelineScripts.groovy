def buildDockerImage(String repoName, String imageName, String version) {
    // build docker image
    bat "docker build -t ${repoName}/${imageName}:${version} -t ${repoName}/${imageName}:latest ."
}

def pushDockerImage(String dockerUsername, String dockerPassword, String repoName, String imageName) {
    // loginto docker hub
    bat "docker login -u ${dockerUsername} -p ${dockerPassword}"
    // push docker image
    bat "docker push ${repoName}/${imageName}"
}

def pullDockerImage(String dockerUsername, String dockerPassword, String repoName, String imageName) {
    // loginto docker hub
    bat "docker login -u ${dockerUsername} -p ${dockerPassword}"
    // pull docker image
    bat "docker pull ${repoName}/${imageName}"
}

// try to network if not exist
def createNetwork(String network) {
    // Check if the network already exists
    def networkExists = bat returnStatus: true, script: "docker network inspect $network > nul 2>&1"

    // If the network does not exist, create it
    if (networkExists != 0) {
        bat "docker network create $network"
    } else {
        echo 'Network already exists.'
    }
}

def runDockerContainer(String containerName, int hostPort, int containerPort, String network, String repoName, String imageName) {
    bat "docker run --name ${containerName} -p ${hostPort}:${containerPort} --network=${network} -d ${repoName}/${imageName}"
}

return this
