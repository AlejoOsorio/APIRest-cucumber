Feature: Actualizar materia
  Como usuario del sistema
  Quiero poder actualizar los datos de una materia existente
  Para mantener la información correcta y actualizada

  Scenario: Actualizar una materia exitosamente
    Given existe una materia con ID 123
    When actualizo la materia con ID 123 con los nuevos datos
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener los datos nuevos

  Scenario: Intentar actualizar una materia con créditos inválidos
    Given existe una materia con ID 123
    When actualizo la materia con ID 123 con los nuevos datos
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe contener el mensaje "Los créditos deben ser al menos 1"
