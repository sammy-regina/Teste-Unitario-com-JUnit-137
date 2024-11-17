##language: pt
#  Funcionalidade: Selecionar Passagem
#    Cenario: Selecionar Passagem com Sucesso
#      Dado que acesso o site Blazedemo
#      Quando seleciono a origem "São Paolo" e destino "Berlin"
#      E clico em procurar voo
#      Entao exibe a frase indicando que o voo sera entre "São Paolo" e "Berlin"

Feature: Selecionar Passagem
  Scenario: Selecionar Passagem com Sucesso
    Given que acesso o site Blazedemo
    When seleciono a origem "São Paolo" e destino "Berlin"
    And clico em procurar voo
    Then exibe a frase indicando que o voo sera entre "São Paolo" e "Berlin"
 2:56:41