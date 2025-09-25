pipeline {
    agent any 

    // Define as variáveis de ambiente que o Allure precisa
    environment {
        // Define onde o Maven gera os arquivos Allure
        ALLURE_RESULTS_DIR = 'target/allure-results' 
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Puxa o código do GitHub usando a URL e Credenciais configuradas no Job
                checkout scm
            }
        }
        
        stage('Run Tests') {
            steps {
                // Comando para rodar em Windows (usa 'bat' em vez de 'sh')
                // O 'clean install' garante que a pasta target seja gerada
                bat 'mvn clean install'
            }
            // Se o teste falhar, a build continua para a próxima etapa (publicação)
            // para garantir que o relatório Allure seja gerado.
            post {
                always {
                    echo 'Testes concluídos. Publicando o relatório...'
                }
            }
        }
        
        stage('Publish Allure Report') {
            steps {
                // Publica o relatório usando o plugin Allure
                allure([
                    includeProperties: false, 
                    // Usa a variável de ambiente para o caminho dos resultados
                    results: [[path: env.ALLURE_RESULTS_DIR]]
                ])
            }
        }
    }
}
