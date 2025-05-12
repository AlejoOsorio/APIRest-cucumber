Feature: Crear una materia
  Como administrador del sistema
  Quiero poder crear nuevas materias (subjects)
  Para agregarlas al sistema académico

  Scenario: Intentar crear una materia con nombre vacío
    Given El sistema está listo para aceptar nuevas materias
    When el cliente envía una solicitud POST con el nombre vacío
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe contener el mensaje "El nombre de la asignatura es requerido"