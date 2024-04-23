
Hi 👋 there! I'm Yagnik Rathod, a passionate Full stack developer from India.

## CI/CD Pipeline Setup Instructions
To run CI and CD Pipeline, you need to create below named parameters in CI Pipeline(Jenkins).

## For CI Pipeline

### Parameters:
name :repositoryUrl, type:string, description: 'The repository URL from which Jenkins takes the code for the build.'

name :repositoryBranch, type:string, description: 'The repository branch from which Jenkins takes the code for the build.'

name :IMAGE_NAME, type:string, description: 'The name of the Docker image.'

name :DOCKER_REPO, type:string, description: 'The name of the repository where the Docker image is going to be pushed.'

name :CD_PIPELINE_NAME, type:string, description: 'The name of the Continuous Delivery (CD) pipeline that will be triggered when the Continuous Integration (CI) pipeline ends.'

name :CONTAINER_NAME, type:string, description: 'The name of the docker container.'

name :NETWORK, type:string, description: 'The name of the network.'

name :HOST_PORT, type:string, description: 'The port number for the host that is going to be redirected to the container 
port.'

name :CONTAINER_PORT, type:string, description: 'The port number for the container.'

name :DOCKERHUB_CRED, type:credentials, description: 'The credentials for Docker Hub, where Jenkins pushes Docker images.'

name :gitCredential, type:credentials, description: 'The credentials of git,from where jenkins checkout repository.'

### Usage of Parameters:
you can use parameters as "params.ParameterName" or direct "ParameterName"

## For CD Pipeline

### Parameters:
To run CD Pipeline, you need to create below named parameters in CD Pipeline.

name :pipelineScriptRepo, type:string, description: 'The path of the repository that contains the pipeline script.'

## Pipeline Scripts

The `pipelineScripts.groovy` script contains common functions used in both pipelines. Here are the functions:

- **buildDockerImage**: Builds a Docker image.
- **pushDockerImage**: Pushes a Docker image to Docker Hub.
- **pullDockerImage**: Pulls a Docker image from Docker Hub.
- **createNetwork**: Tries to create a Docker network if it does not already exist.
- **runDockerContainer**: Runs a Docker container.

# Note : name of pipe line script should be "pipelineScripts".


# This README provides instructions and examples for setting up and using your Jenkins CI/CD pipeline. Feel free to modify it according to your specific needs and preferences. Let me know if you need further assistance!
