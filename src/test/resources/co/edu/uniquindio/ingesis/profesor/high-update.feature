Feature: Actualizar un profesor
  Como administrador del sistema
  Quiero poder actualizar completamente los datos de un profesor
  Para asegurar que la información esté actualizada y sea precisa

  Scenario: Actualizar un profesor exitosamente
    Given existe un profesor con ID 102
    When actualizo completamente el profesor con ID 102 con los nuevos datos
    Then la respuesta debe tener el código de estado 200
    And el cuerpo de la respuesta debe contener los datos actualizados del profesor
