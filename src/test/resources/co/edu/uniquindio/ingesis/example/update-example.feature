Feature: Actualizar un ejemplo
  Como profesor
  Quiero poder actualizar un ejemplo existente
  Para mejorar su contenido o corregir errores

  Scenario: Actualizar exitosamente un ejemplo
    Given Existe un ejemplo con ID 200
    When actualizo el título del ejemplo con ID 200 a "Ejemplo actualizado" y la dificultad a "Difícil"
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener el mensaje "Ejemplo actualizado"

  Scenario: Intentar actualizar un ejemplo con descripción vacía
    Given Existe un ejemplo con ID 100
    When actualizo el título del ejemplo con ID 100 a "" y la dificultad a "Difícil"
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe mostrar el mensaje "El título no puede estar vacío"
