Feature: Actualizar un programa
  Como estudiante
  Quiero poder actualizar la información de un programa
  Para corregir errores o mejorar la presentación

  Scenario: Actualizar exitosamente un programa
    Given Existe un programa con ID 700
    When actualizo el título del programa con ID 700 a "Calculadora Avanzada"
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener el mensaje "Programa actualizado con éxito"

  Scenario: Intentar actualizar un programa con descripción vacía
    Given Existe un programa con ID 700
    When actualizo la descripción del programa con ID 700 a ""
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe mostrar el mensaje "La descripción es requerida"
