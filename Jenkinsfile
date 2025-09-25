pipeline {
    agent any 

    environment {
        ALLURE_RESULTS_DIR = 'target/allure-results' 
    }

    stages {
        stage('Run Tests') {
            steps {
                echo 'Iniciando testes Maven...'
                bat 'mvn clean install'
            }
        }

        stage('Publish Allure Report') {
            steps {
                echo 'Publicando Relatório Allure...'
                allure([
                    includeProperties: false, 
                    results: [[path: env.ALLURE_RESULTS_DIR]]
                ])
            }
        }
    }
}
