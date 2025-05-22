Feature: Actualizar un comentario
  Como usuario del sistema
  Quiero poder actualizar el contenido de un comentario existente
  Para corregir errores o agregar información adicional

  Scenario: Actualizar exitosamente un comentario
    Given Existe un comentario con ID 202
    When actualizo el contenido del comentario con ID 202 a "Contenido actualizado"
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener el mensaje "Contenido actualizado"