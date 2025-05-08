Feature: Consultar un estudiante por ID
  Como administrador del sistema
  Quiero poder consultar la información de un estudiante específico
  Para acceder a sus datos académicos de forma individual

  Scenario: Consultar un estudiante existente exitosamente
    Given Existe un estudiante con ID 321
    When consulto al estudiante con ID 321
    Then la respuesta debe tener el código de estado 200

  Scenario: Intentar consultar un estudiante que no existe
    Given No existe un estudiante con ID 012
    When consulto al estudiante con ID 012
    Then la respuesta debe tener el código de estado 404
    And el cuerpo de la respuesta debe mostrar el mensaje "Estudiante no encontrado"
