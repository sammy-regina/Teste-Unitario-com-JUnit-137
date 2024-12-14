Feature: Selecionar Passagem PO
  Scenario: Selecionar Passagem com Sucesso PO
    Given que acesso o site Blazedemo PO
    When seleciono a origem "Boston" e destino "Dublin" PO
    And clico em procurar voo PO
    Then exibe a frase indicando que o voo sera entre "Boston" e "Dublin" PO