Feature: Registrar un nuevo estudiante
  Como administrador del sistema
  Quiero poder registrar nuevos estudiantes
  Para agregarlos al sistema académico

  Scenario: Crear un estudiante exitosamente
    Given Se tienen datos válidos para el estudiante
    When registro al nuevo estudiante
    Then la respuesta debe tener el código de estado 201

  Scenario: Intentar crear un estudiante con datos inválidos
    Given Se tiene el correo invalido para el estudiante
    When registro al nuevo estudiante
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe mostrar el mensaje "debe ser una dirección de correo electrónico con formato correcto"
