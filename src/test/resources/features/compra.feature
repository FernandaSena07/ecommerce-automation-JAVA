Feature: Fluxo de Compra

  Scenario: Adicionar itens ao carrinho e finalizar a compra
    Given que estou logado na pagina de inventario
    When adiciono o "Sauce Labs Backpack" ao carrinho
    And clico no carrinho
    And clico no botão de checkout
    And preencho os dados "Fernanda", "Souza" e "01234-567"
    And clico no botão de continuar
    And clico no botão de finalizar a compra
    Then devo ver a mensagem de compra finalizada com sucesso

  Scenario: Filtrar os produtos por preço do menor para o maior
    Given que estou logado na pagina de inventario
    When filtro os produtos por "Price (low to high)"
    Then os produtos devem estar ordenados por preço do menor para o maior