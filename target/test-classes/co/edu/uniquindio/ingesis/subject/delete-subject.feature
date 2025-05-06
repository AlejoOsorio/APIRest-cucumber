Feature: Eliminar materia
  Como usuario del sistema
  Quiero poder eliminar una materia existente por su ID
  Para mantener actualizada la base de datos de materias

  Scenario: Eliminar una materia existente exitosamente
    Given existe una materia con ID 123
    When elimino la materia con ID 123
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener el mensaje "Materia eliminada con éxito"

  Scenario: Eliminar una materia que no existe
    Given no existe una materia con ID 999
    When elimino la materia con ID 999
    Then la respuesta debe tener el código de estado 404
    And el cuerpo de la respuesta debe contener el mensaje "Materia no encontrada"
