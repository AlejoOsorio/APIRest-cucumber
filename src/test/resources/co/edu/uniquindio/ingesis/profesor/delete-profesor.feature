Feature: Eliminar profesor
  Como administrador del sistema
  Quiero poder eliminar un profesor existente por su ID
  Para mantener actualizada la base de datos de profesores

  Scenario: Eliminar un profesor exitosamente
    Given existe un profesor con ID 215
    When elimino el profesor con ID 215
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener el mensaje "El profesor fue eliminado correctamente"

  Scenario: Intentar eliminar un profesor que no existe
    Given no existe un profesor con ID 999
    When elimino el profesor con ID 999
    Then la respuesta debe tener el código de estado 404
