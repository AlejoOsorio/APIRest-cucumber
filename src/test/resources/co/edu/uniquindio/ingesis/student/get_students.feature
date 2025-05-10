Feature: Consultar estudiantes
  Como administrador del sistema
  Quiero poder consultar los estudiantes registrados
  Para visualizar y gestionar su información académica

  Scenario: Consultar estudiantes de forma paginada exitosamente
    Given Existen 20 o mas estudiantes registrados en el sistema
    When consulto la lista de estudiantes con parámetros de paginación válidos
    Then la respuesta debe tener el código de estado 200
    And la respuesta debe contener 20 elementos
