Feature: Consulta de estudiantes

  Scenario: Consulta paginada exitosa de estudiantes
    Given hay estudiantes registrados
    When invoco el servicio GET /students con offset y limit válidos
    Then responde 200 OK
    And retorna una lista de estudiantes

  Scenario: Error del servidor al consultar estudiantes
    Given el sistema falla al consultar estudiantes
    When invoco el servicio GET /students
    Then responde 500 error interno del servidor
    And muestra mensaje "Error al obtener estudiantes"