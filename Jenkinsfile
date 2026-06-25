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
            echo 'Model service code checkout completed.'
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

    stage('SonarQube Analysis') {
        steps {
            withSonarQubeEnv('SonarQube') {
                bat '''
                    mvn sonar:sonar ^
                    -Dsonar.projectKey=healthcare-model-service ^
                    -Dsonar.projectName=healthcare-model-service ^
                    -Dsonar.host.url=%SONAR_HOST_URL% ^
                    -Dsonar.login=%SONAR_AUTH_TOKEN%
                '''
            }
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
        echo 'Model service CI + SonarQube pipeline completed successfully.'
    }

    failure {
        echo 'Model service CI + SonarQube pipeline failed. Check console logs.'
    }
}

}
