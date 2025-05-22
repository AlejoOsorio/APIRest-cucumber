Feature: Crear un ejemplo
  Como profesor
  Quiero poder registrar un ejemplo de código
  Para compartir material educativo con los estudiantes

  Scenario: Crear exitosamente un ejemplo
    Given existe un profesor con ID 301
    When creo un ejemplo con título "Ejemplo de recursión", descripción "Muestra cómo usar recursividad", código "def f(): pass", tema "Programación", dificultad "Media", y asociado al profesor con ID 301
    Then la respuesta debe tener el código de estado 201
    And el cuerpo de la respuesta debe mostrar el mensaje "Ejemplo de recursión"

  Scenario: Intentar crear un ejemplo sin código fuente
    Given existe un profesor con ID 302
    When creo un ejemplo con título "Ejemplo vacío", descripción "Sin código", código "", tema "Algoritmos", dificultad "Fácil", y asociado al profesor con ID 302
    Then la respuesta debe tener el código de estado 400
    And el cuerpo de la respuesta debe mostrar el mensaje "El código no puede estar vacío"
