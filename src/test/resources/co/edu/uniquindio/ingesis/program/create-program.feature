Feature: Crear un programa
  Como estudiante
  Quiero poder registrar un programa
  Para enviar mis desarrollos al sistema

  Scenario: Intentar crear un programa sin código fuente
    Given Existe un estudiante con ID 889
    When creo un programa con título "", descripción "", y código ""
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe mostrar el mensaje "El código es requerido"
