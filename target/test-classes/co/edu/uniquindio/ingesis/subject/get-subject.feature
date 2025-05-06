Feature: Obtener una materia por ID

  Scenario: Obtener una materia existente con ID válido
    Given el sistema tiene una materia registrada con ID 1
    When el cliente solicita la materia con ID 1
    Then el sistema responde con código 200 y los detalles de la materia

  Scenario: Obtener una materia con un ID que no existe
    Given el sistema no tiene ninguna materia con ID 999
    When el cliente solicita la materia con ID 999
    Then el sistema responde con código 404 indicando que la materia no fue encontrada