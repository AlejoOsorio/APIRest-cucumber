Feature: Actualización parcial de un profesor
  Como administrador del sistema
  Quiero poder modificar solo algunos campos de un profesor
  Para actualizar información puntual sin sobrescribir todo

  Scenario: Actualizar parcialmente el número de teléfono del profesor
    Given existe un profesor con ID 105
    When realizo una actualización del telefono del profesor con ID 105
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener el nuevo telefono

  Scenario: Intentar actualizar con email inválido
    Given existe un profesor con ID 105
    When realizo una actualización parcial del profesor con ID 105
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe contener el mensaje "must be a well-formed email address"
