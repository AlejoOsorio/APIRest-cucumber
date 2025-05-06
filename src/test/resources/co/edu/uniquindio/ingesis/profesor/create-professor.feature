Feature: Crear un nuevo profesor
  Como administrador del sistema
  Quiero poder registrar nuevos profesores
  Para agregarlos al sistema académico

  Scenario: Crear un profesor exitosamente
    Given Se tienen datos validos para el profesor
    When registro al nuevo profesor
    Then la respuesta debe tener el código de estado 201
    And el cuerpo de la respuesta debe contener los datos validos

  Scenario: Intentar crear un profesor sin nombre
    Given Se tienen datos invalidos para el profesor
    When intento registrar al nuevo profesor
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe contener el mensaje "El nombre es requerido"
