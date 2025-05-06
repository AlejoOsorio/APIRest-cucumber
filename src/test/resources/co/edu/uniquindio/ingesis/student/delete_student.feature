Feature: Eliminación de estudiante

  Scenario: Eliminación exitosa de un estudiante
    Given el estudiante con ID "123" existe
    When invoco el servicio DELETE /students/123
    Then responde 200 OK
    And muestra mensaje "Estudiante eliminado exitosamente"

  Scenario: Error al eliminar estudiante
    Given el sistema falla al intentar eliminar el estudiante
    When invoco el servicio DELETE /students/123
    Then responde 500 error interno del servidor
    And muestra mensaje "Error al eliminar el estudiante"