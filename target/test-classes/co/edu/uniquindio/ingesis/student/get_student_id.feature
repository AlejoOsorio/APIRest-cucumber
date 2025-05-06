Feature: Consulta de un estudiante por ID

  Scenario: Consulta exitosa de un estudiante existente
    Given el estudiante con ID "123" existe
    When invoco el servicio GET /students/123
    Then responde 200 OK
    And retorna la información del estudiante

  Scenario: Consulta de estudiante inexistente
    Given el estudiante con ID "012" no existe
    When invoco el servicio GET /students/999
    Then responde 404 datos inexistentes
    And muestra mensaje "Estudiante no encontrado"