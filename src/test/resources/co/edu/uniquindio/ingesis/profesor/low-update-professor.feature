Feature: Actualización parcial de un profesor
  Como administrador del sistema
  Quiero poder modificar solo algunos campos de un profesor
  Para actualizar información puntual sin sobrescribir todo

  Scenario: Actualizar parcialmente el número de teléfono del profesor
    Given existe un profesor con ID 105
    When realizo una actualización minima del profesor con ID 105
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener los nuevos datos

  Scenario: Intentar actualizar con email inválido
    Given existe un profesor con ID 105
    When realizo una actualización del email del profesor con ID 105
    Then la respuesta debe tener el código de estado 400
