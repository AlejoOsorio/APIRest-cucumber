Feature: Eliminar un ejemplo
  Como profesor
  Quiero poder eliminar un ejemplo
  Para remover material que ya no es relevante

  Scenario: Eliminar exitosamente un ejemplo
    Given Existe un ejemplo con ID 100
    When elimino el ejemplo con ID 100
    Then la respuesta debe tener el código de estado 200

  Scenario: Intentar eliminar un ejemplo inexistente
    Given No existe un ejemplo con ID 999
    When elimino el ejemplo con ID 999
    Then la respuesta debe tener el código de estado 404
    And el cuerpo de la respuesta debe mostrar el mensaje "Ejemplo no encontrado"
