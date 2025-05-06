Feature: Obtener lista de materias
  Como usuario del sistema
  Quiero poder obtener una lista paginada de materias
  Para visualizar los registros disponibles de manera organizada

  Scenario: Obtener la primera página de materias con valores por defecto
    When solicito la lista de materias sin parámetros de paginación
    Then la respuesta debe tener el código de estado 200
    And la respuesta debe contener 20 materias

  Scenario: Obtener una página específica de materias
    When solicito la lista de materias con offset 20 y limit 5
    Then la respuesta debe tener el código de estado 200
    And la respuesta debe contener 5 materias

  Scenario: Obtener una página vacía si no hay materias en ese rango
    When solicito la lista de materias con offset 1000 y limit 10
    Then la respuesta debe tener el código de estado 200
    And la respuesta debe contener 0 materias
