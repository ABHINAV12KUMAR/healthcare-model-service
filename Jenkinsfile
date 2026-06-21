pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
        timeout(time: 15, unit: 'MINUTES')
        disableConcurrentBuilds()
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
                echo 'Code checkout completed.'
            }
        }

        stage('Check Maven') {
            steps {
                bat 'mvn -v'
            }
        }

        stage('Build Model') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Model service CI pipeline completed successfully.'
        }

        failure {
            echo 'Model service CI pipeline failed. Check console logs.'
        }
    }
}