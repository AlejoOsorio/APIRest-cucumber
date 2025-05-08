Feature: Actualizar una materia
  Como usuario del sistema
  Quiero poder actualizar los datos de una materia existente
  Para mantener la información correcta y actualizada

  Scenario: Actualizar exitosamente una materia
    Given Existe una materia con ID 466
    And sus datos son correctos
    When actualizo la materia con ID 466
    Then la respuesta debe tener el código de estado 200

  Scenario: Intentar actualizar una materia con créditos inválidos
    Given Existe una materia con ID 466
    And los datos para acutlizar tienen créditos menores a 1
    When actualizo la materia con ID 466
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe mostrar el mensaje "Los créditos deben ser al menos 1"
