Feature: Actualización parcial de un estudiante

  Scenario: Actualización parcial exitosa
    Given el estudiante con ID "123" existe y envío datos parciales válidos
    When invoco el servicio PATCH /students/123
    Then responde 200 OK
    And retorna el estudiante actualizado parcialmente

  Scenario: Error del servidor en actualización parcial
    Given el sistema falla al hacer la actualización parcial
    When invoco el servicio PATCH /students/123
    Then responde 500 error interno del servidor
    And muestra mensaje "Error al actualizar estudiante"