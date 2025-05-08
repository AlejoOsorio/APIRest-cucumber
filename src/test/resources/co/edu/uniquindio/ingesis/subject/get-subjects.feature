Feature: Consultar lista de materias
  Como usuario del sistema
  Quiero poder obtener una lista paginada de materias
  Para visualizar los registros disponibles de manera organizada

  Scenario: Consultar la primera página de materias sin parámetros de paginación
    Given existen 20 o mas materias
    When consulto la lista de materias sin especificar offset ni limit
    Then la respuesta debe tener el código de estado 200
    And la respuesta debe contener 20 elementos

  Scenario: Consultar una página específica de materias
    Given existen 10 o mas materias
    When consulto la lista de materias con offset 1 y limit 5
    Then la respuesta debe tener el código de estado 200
    And la respuesta debe contener 5 elementos
