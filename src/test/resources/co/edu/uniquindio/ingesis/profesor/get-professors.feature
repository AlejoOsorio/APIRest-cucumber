Feature: Obtener lista de profesores
  Como usuario del sistema
  Quiero poder obtener una lista paginada de profesores
  Para visualizar los registros de manera ordenada y controlada

  Scenario: Obtener la primera página de profesores con valores por defecto
    Given existen 20 o mas profesores
    When solicito la lista de profesores sin parámetros de paginación
    Then la respuesta debe tener el código de estado 200
    And la respuesta debe contener 20 elementos

  Scenario: Obtener una página específica de profesores
    Given existen 10 o mas profesores
    When solicito la lista de profesores con offset 2 y limit 5
    Then la respuesta debe tener el código de estado 200
    And la respuesta debe contener 5 elementos
