pipeline {
    agent any 

    environment {
        // Define onde o Maven gera os resultados
        ALLURE_RESULTS_DIR = 'target/allure-results' 
    }

    stages {
        // REMOVER O CHECKOUT EVITA O ERRO DO SCM, MAS REQUER QUE O CÓDIGO JÁ ESTEJA LÁ
        // stage('Checkout Code') { /* REMOVIDO */ }
        
        stage('Run Tests') {
            steps {
                echo 'Iniciando testes Maven...'
                // Comando para rodar em Windows
                bat 'mvn clean install'
            }
        }
        
        stage('Publish Allure Report') {
            steps {
                echo 'Publicando Relatório Allure...'
                // Publica o relatório usando o plugin Allure
                allure([
                    includeProperties: false, 
                    results: [[path: env.ALLURE_RESULTS_DIR]]
                ])
            }
        }
    }
}
