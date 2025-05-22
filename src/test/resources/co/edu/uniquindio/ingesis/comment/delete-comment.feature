Feature: Eliminar un comentario
  Como usuario del sistema
  Quiero poder eliminar un comentario
  Para remover información que ya no es relevante

  Scenario: Eliminar exitosamente un comentario
    Given Existe un comentario con ID 700
    When elimino el comentario con ID 700
    Then la respuesta debe tener el código de estado 200

  Scenario: Intentar eliminar un comentario inexistente
    Given No existe un comentario con ID 999
    When elimino el comentario con ID 999
    Then la respuesta debe tener el código de estado 404
    And el cuerpo de la respuesta debe mostrar el mensaje "Comentario no encontrado"
