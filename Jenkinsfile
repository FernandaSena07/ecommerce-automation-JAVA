pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Esta etapa usa o SCM que você já configurou no job
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                // Comando para rodar em Windows
                bat 'mvn clean install'
            }
        }
        
        stage('Publish Allure Report') {
            // Este passo usa o plugin Allure para ler os resultados do Maven
            steps {
                allure([
                    includeProperties: false, 
                    // Caminho para a pasta onde o Maven gera os resultados
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
}
