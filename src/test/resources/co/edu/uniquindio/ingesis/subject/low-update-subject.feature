Feature: Actualizar parcialmente una materia
  Como usuario del sistema
  Quiero poder actualizar parcialmente una materia existente
  Para modificar solo los campos necesarios sin sobrescribir los demás

  Scenario: Actualizar parcialmente el nombre de una materia
    Given Existe una materia con ID 35
    When actualizo algunos campos de la materia con ID 35
    Then la respuesta debe tener el código de estado 200
