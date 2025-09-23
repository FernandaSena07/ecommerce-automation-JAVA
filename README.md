# E-commerce Automation - Projeto Java

Automação de testes para a plataforma de e-commerce **Sauce Demo** usando **Java**, **Maven**, **Selenium** e **Cucumber**.

O objetivo do projeto é validar o fluxo de compra completo e a funcionalidade de filtro de produtos da aplicação.

### 🧪 Testes Implementados

Os seguintes cenários de teste estão automatizados:

- **🔑 Login**
    * Acesso com um usuário válido.
- **🛒 Fluxo de Compra**
    * Adicionar um produto ao carrinho.
    * Navegar até o checkout.
    * Preencher as informações do comprador.
    * Finalizar a compra com sucesso.
- **🔎 Filtro de Produtos**
    * Filtrar produtos por preço do menor para o maior.
    * Validar a ordenação dos produtos na tela.

### ⚙️ Configuração & Execução

#### Pré-requisitos
- **☕ Java Development Kit (JDK)**: Versão 17 ou superior.
- **📦 Apache Maven**: Versão 3.6.0 ou superior.
- Um navegador (ex: **🌐 Google Chrome**).

#### Executar os testes localmente
Para rodar todos os cenários de teste, navegue até a pasta raiz do projeto no seu terminal e execute o seguinte comando Maven:

### 🚀Jenkins Pipeline
Este projeto possui um `Jenkinsfile` que define uma pipeline de testes automatizados para rodar a cada novo push no repositório.

#### 🔄Fluxo da Pipeline
* O Jenkins faz o **checkout** do código do repositório GitHub.
* Executa o comando **`mvn clean install`** para construir o projeto, baixar as dependências e rodar todos os testes de automação.
* A pipeline gera os resultados dos testes que podem ser visualizados na interface do Jenkins.

#### 📝Observações
* O Jenkins deve ter o plugin **Maven Integration** e **Git** instalados para a pipeline funcionar.
* O histórico de builds e relatórios de execução ficam acessíveis diretamente na interface do Jenkins.
