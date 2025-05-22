Feature: Crear un comentario
  Como usuario del sistema
  Quiero poder registrar comentarios para un programa
  Para dejar observaciones o retroalimentación sobre el programa

  Scenario: Crear exitosamente un comentario
    Given Existe un programa con ID 101
    When creo un comentario con el contenido "Muy buen programa" para el programa con ID 101
    Then la respuesta debe tener el código de estado 201
    And el cuerpo de la respuesta debe contener el mensaje "Muy buen programa"
