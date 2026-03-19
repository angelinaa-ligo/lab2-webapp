pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "angelina/lab2-webapp"
        DOCKER_CREDS = "dockerhub-creds"
    }

    stages { // <--- todos os stages devem estar aqui
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/angelinaa-ligo/lab2-webapp.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: DOCKER_CREDS,
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Docker Push') {
            steps {
                sh 'docker push $DOCKER_IMAGE'
            }
        }
    } 
} 
