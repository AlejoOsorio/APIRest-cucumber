Feature: Eliminar un programa
  Como estudiante
  Quiero poder eliminar un programa
  Para remover entregas innecesarias o erróneas

  Scenario: Eliminar exitosamente un programa
    Given Existe un programa con ID 700
    When elimino el programa con ID 700
    Then la respuesta debe tener el código de estado 200

  Scenario: Intentar eliminar un programa inexistente
    Given No existe un programa con ID 999
    When elimino el programa con ID 999
    Then la respuesta debe tener el código de estado 404
    And el cuerpo de la respuesta debe mostrar el mensaje "No se pudo eliminar el programa"
