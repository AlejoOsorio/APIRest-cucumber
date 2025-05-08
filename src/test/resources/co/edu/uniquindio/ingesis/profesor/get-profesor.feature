Feature: Obtener datos de un profesor
  Como usuario del sistema
  Quiero poder consultar la información de un profesor por su ID
  Para conocer sus datos registrados

  Scenario: Obtener información de un profesor existente
    Given existe un profesor con ID 10 con datos validos
    When solicito la información del profesor con ID 10
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener los datos del profesor:

  Scenario: Consultar un profesor que no existe
    Given no existe un profesor con ID 999
    When solicito la información del profesor con ID 999
    Then la respuesta debe tener el código de estado 404
