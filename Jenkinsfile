pipeline {
    agent any 

    // Opcional: Define a variável de ambiente (boa prática)
    environment {
        ALLURE_RESULTS_DIR = 'target/allure-results' 
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Puxa o código do GitHub usando a configuração do Job
                checkout scm
            }
        }
        
        stage('Run Tests') {
            steps {
                // Comando para rodar em Windows
                bat 'mvn clean install'
            }
        }
        
        // ESTÁGIO CRUCIAL QUE PRECISA ESTAR NO ARQUIVO
        stage('Publish Allure Report') {
            steps {
                allure([
                    includeProperties: false, 
                    // Caminho para a pasta onde o Maven gerou os resultados
                    results: [[path: env.ALLURE_RESULTS_DIR]]
                ])
            }
        }
    }
}
