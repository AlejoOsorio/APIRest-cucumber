Feature: Actualización parcial de una materia
  Como usuario del sistema
  Quiero poder actualizar parcialmente una materia existente
  Para modificar solo los campos necesarios sin sobrescribir los demás

  Background:
    Given el servicio de materias está disponible

  Scenario: Actualizar parcialmente el nombre de una materia
    Given existe una materia con ID 123
    When realizo una actualización del nombre de la materia con ID 123
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener los datos del subject con el nombre actualizado

  Scenario: Actualización parcial con créditos inválidos
    Given existe una materia con ID 123                 |
    When realizo una actualización de los cretidos de la materia con ID 123
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe contener el mensaje "Los créditos deben ser al menos 1"
