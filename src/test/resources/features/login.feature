Feature: Realizar login no sistema
  Como um usuário do e-commerce
  Desejo realizar login
  Para que eu possa acessar minha conta e gerenciar meus pedidos

  Scenario: Login com sucesso com credenciais válidas
    Given que estou na página de login
    When preencho o campo de usuario com "standard_user"
    And preencho o campo de senha com "secret_sauce"
    And clico no botão de login
    Then devo ser redirecionado para a página de inventário