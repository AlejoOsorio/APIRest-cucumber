Feature: Actualizar completamente un estudiante
  Como administrador del sistema
  Quiero poder reemplazar toda la información de un estudiante
  Para mantener sus datos académicos actualizados de forma integral

  Scenario: Actualización completa exitosa de un estudiante
    Given Existe un estudiante con ID 333
    And Los datos proporcionados para la actualización completa son validos
    When actualizo completamente al estudiante con ID 333
    Then la respuesta debe tener el código de estado 200

  Scenario: Error de validación al actualizar completamente un estudiante
    Given Existe un estudiante con ID 333
    And Los datos proporcionados para la actualización completa son inválidos
    When actualizo completamente al estudiante con ID 333
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe mostrar el mensaje "formato correcto"
