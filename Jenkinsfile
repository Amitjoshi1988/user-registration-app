pipeline {
    agent any
    tools {
        maven 'Maven 3.9.4'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build & Deploy') {
            steps {
                sh 'docker-compose down'
                sh 'docker-compose up -d --build'
            }
        }
    }
    post {
        success {
            echo ' User registration app built and deployed!'
        }
        failure {
            echo ' Pipeline failed!'
        }
    }
}