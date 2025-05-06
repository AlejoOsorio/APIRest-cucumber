Feature: Eliminar profesor
  Como administrador del sistema
  Quiero poder eliminar un profesor existente por su ID
  Para mantener actualizada la base de datos de profesores

  Background:
    Given el servicio de profesores está disponible

  Scenario: Eliminar un profesor exitosamente
    Given existe un profesor con ID 101
    When elimino el profesor con ID 101
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener el mensaje "Profesor eliminado con éxito"

  Scenario: Intentar eliminar un profesor que no existe
    Given no existe un profesor con ID 999
    When elimino el profesor con ID 999
    Then la respuesta debe tener el código de estado 404
    And el cuerpo de la respuesta debe contener el mensaje "Profesor no encontrado"
