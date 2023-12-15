pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    agent any

    stages {
        stage('Set up Environment') {
            steps {
                script {
                    // Define Maven tool using the tool installer name
                    def mvnHome = tool name: 'Maven 3.9.6', type: 'maven'
                    env.PATH = "${mvnHome}/bin:${env.PATH}"
                }
            }
        }

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

        // Add more stages as needed below...
    }
}
