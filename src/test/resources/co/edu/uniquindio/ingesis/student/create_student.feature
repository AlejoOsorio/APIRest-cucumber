Feature: Registro de un nuevo estudiante

  Scenario: Creación exitosa de un nuevo estudiante
    Given registro de un estudiante con los datos válidos
    When invoco el servicio POST /students
    Then responde 201 Created
    And retorna el objeto estudiante creado

  Scenario: Creación de estudiante con datos inválidos
    Given registro de un estudiante con los datos inválidos
    When invoco el servicio POST /students
    Then responde 400 Bad Request
    And muestra mensaje "Información inválida"

  Scenario: Error del servidor al crear estudiante
    Given el sistema presenta una falla al crear el estudiante
    When invoco el servicio POST /students
    Then responde 500 Internal Server Error
    And muestra mensaje "Error al crear el estudiante"