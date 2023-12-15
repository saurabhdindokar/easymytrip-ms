pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    agent any

    tools {
        // Use 'Maven' (capitalized) and specify the tool by its installer name
        Maven 'Maven 3.9.6'
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

        // Add more stages as needed below...
    }
}
