Feature: Actualización total de un estudiante

  Scenario: Actualización completa exitosa
    Given el estudiante con ID "123" existe y tengo nuevos datos válidos
    When invoco el servicio PUT /students/123
    Then responde 200 OK
    And retorna el estudiante actualizado

  Scenario: Error de validación en actualización completa
    Given los datos proporcionados para actualizar son inválidos
    When invoco el servicio PUT /students/123
    Then responde 400 datos invalidos
    And muestra mensaje "Información inválida"