pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/FernandaSena07/ecommerce-automation-JAVA.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}
