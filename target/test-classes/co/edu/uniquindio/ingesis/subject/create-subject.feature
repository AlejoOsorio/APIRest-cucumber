Feature: Crear un subject

  Scenario: Crear un subject con valor exitoso
    Given el sistema está listo para aceptar nuevas materias
    When el cliente envía una solicitud POST con un subject válido
    Then el sistema responde con código 201 y los detalles del subject creado

  Scenario: Crear un subject con nombre vacío
    Given el sistema está listo para aceptar nuevas materias
    When el cliente envía una solicitud POST con el nombre vacío
    Then el sistema responde con un error de validación indicando que el nombre es requerido

  Scenario: Crear un subject con descripción vacía
    Given el sistema está listo para aceptar nuevas materias
    When el cliente envía una solicitud POST con la descripción vacía
    Then el sistema responde con un error de validación indicando que la descripción es requerida

  Scenario: Crear un subject con créditos menores a 1
    Given el sistema está listo para aceptar nuevas materias
    When el cliente envía una solicitud POST con créditos igual a 0
    Then el sistema responde con un error de validación indicando que los créditos deben ser al menos 1