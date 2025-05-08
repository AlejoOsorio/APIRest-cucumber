Feature: Eliminar un estudiante
  Como administrador del sistema
  Quiero poder eliminar estudiantes existentes
  Para mantener actualizada la información del sistema académico

  Scenario: Eliminar un estudiante exitosamente
    Given Existe un estudiante con ID "123"
    When elimino al estudiante con ID "123"
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe mostrar el mensaje "El estudiante fue eliminado correctamente"
