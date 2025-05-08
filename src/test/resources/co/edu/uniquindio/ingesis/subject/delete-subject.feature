Feature: Eliminar una materia
  Como usuario del sistema
  Quiero poder eliminar una materia existente por su ID
  Para mantener actualizada la base de datos de materias

  Scenario: Eliminar exitosamente una materia existente
    Given Existe una materia con ID 555
    When elimino la materia con ID 555
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe mostrar el mensaje "Materia eliminada correctamente"

  Scenario: Intentar eliminar una materia que no existe
    Given No existe una materia con ID 999
    When elimino la materia con ID 999
    Then la respuesta debe tener el código de estado 404
    And el cuerpo de la respuesta debe mostrar el mensaje "No se encontro la materia con ID: 999"
