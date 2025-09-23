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
                // Mude de 'sh' para 'bat' para rodar em Windows
                bat 'mvn clean install'
            }
        }
    }
}
