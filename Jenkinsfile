pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    agent any

    tools {
        maven 'maven 3.9.6'
    }

    stages {
        stage('Code Compilation') {
            steps {
                echo 'Code Compilation is In Progress!'
                sh 'mvn --version'
                sh 'mvn clean compile'
            }
        }

        stage('Code QA Execution') {
            steps {
                echo 'Junit Test case check in Progress!'
                sh 'mvn --version'
                sh 'mvn clean test'
            }
        }

        stage('Code Package') {
            steps {
                echo 'Creating war artifact'
                sh 'java -version'
                sh 'mvn clean package'
            }
        }

        stage('Build and Tag Docker Image') {
            steps {
                script {
                    // Build Docker image and tag it
                    docker.withRegistry('https://registry.hub.docker.com', DOCKER_HUB_CREDENTIALS) {
                        def customImage = docker.build(DOCKER_IMAGE)
                        customImage.push("latest")
                    }
                }
            }
        }

        stage('Push Docker Image to AWS ECR') {
            steps {
                script {
                    // Push Docker image to AWS ECR
                    withAWS(region: AWS_REGION, credentials: AWS_ECR_CREDENTIALS) {
                        docker.withRegistry("https://${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com", 'ecr:us-west-2') {
                            def customImage = docker.image(DOCKER_IMAGE)
                            customImage.push()
                        }
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    withKubeConfig([credentialsId: 'kubernetes-config-id', serverUrl: 'https://your-kubernetes-cluster']) {
                        sh 'kubectl apply -f deployment.yaml'
                    }
                }
            }
        }
    }
}
