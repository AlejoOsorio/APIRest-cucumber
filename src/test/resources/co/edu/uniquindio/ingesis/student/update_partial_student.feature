Feature: Actualizar parcialmente un estudiante
  Como administrador del sistema
  Quiero poder modificar parcialmente la información de un estudiante
  Para mantener sus datos actualizados sin reemplazar toda la información

  Scenario: Actualización parcial exitosa de un estudiante
    Given Existe un estudiante con ID 428
    When actualizo parcialmente al estudiante con ID 428
    Then la respuesta debe tener el código de estado 200

  Scenario: Error del sistema al realizar la actualización parcial
    Given No existe un estudiante con ID 982
    When actualizo parcialmente al estudiante con ID 928
    Then la respuesta debe tener el código de estado 404
    And el cuerpo de la respuesta debe mostrar el mensaje "Estudiante no encontrado"
