-- Professors
INSERT INTO professor (id, name, lastName, identification, email, birthDate, phoneNumber)
VALUES (10, 'Mario', 'Morales', '369823754', 'mario@gmail.com', '1998-02-15', '65988888'),
       (102, 'Fernando', 'Arias', '102', 'fernando@gmail.com', '1998-02-15', '651988888'),
       (105, 'Stiven', 'Carmelo', '10242', 'stiven@gmail.com', '2002-02-15', '6088888'),
       (215, 'Juan', 'Garcia', '3698754', 'juan@gmail.com', '2000-09-19', '3669554875'),
       (301, 'Laura', 'Martínez', '789654123', 'laura.martinez@uniquindio.edu.co', '1985-06-23', '3175551122'),
       (302, 'Andrés', 'Salazar', '456123789', 'andres.salazar@uniquindio.edu.co', '1990-11-05', '3124443344')
    ON CONFLICT (id) DO NOTHING;

-- Students
INSERT INTO students (id, name, lastname, identification, email, birthdate, semester)
VALUES (123, 'Andres', 'Alzate', '102422', 'andres@gmail.com', '2000-02-15', 3),
       (321, 'Maria', 'Alzate', '1022422', 'marias@gmail.com', '1999-02-15', 3),
       (333, 'Pedro', 'Zuluaga', '333', 'pedro@gmail.com', '2002-02-15', 1),
       (428, 'Andres', 'Garcia', '1024222', 'andresgar@gmail.com', '2004-02-15', 2),
       (888, 'Laura', 'Martínez', '1009876543', 'laura.martinez@example.com', '2001-07-12', 4),
       (889, 'Carlos', 'Ramírez', '1001234567', 'carlos.ramirez@example.com', '2000-11-03',6)
ON CONFLICT (id) DO NOTHING;

-- Subjects
INSERT INTO subject (id, name, description, credits)
VALUES (1, 'Matematicas generales', 'la base de las matematicas', 3),
       (35, 'Algoritmos y Estructuras de Datos', 'Estudio de algoritmos fundamentales y estructuras de datos avanzadas',
        4),
       (466, 'Estructuras de Datos', 'Estudio de estructuras fundamentales como listas, pilas y árboles', 4),
       (555, 'Programación I', 'Introducción a la programación con Java', 3)
    ON CONFLICT (id) DO NOTHING;

-- Program
INSERT INTO programs (id, title, description, code, student_id)
VALUES (700, 'Programa de Saludo', 'Este programa imprime un saludo en consola',
        E'public class Saludar {\n    public static void main(String[] args) {\n        System.out.println("Hola mundo");\n    }\n}',
        888),

       (101, 'Suma de dos números', 'Este programa suma dos números y muestra el resultado',
        E'public class Sumar {\n    public static void main(String[] args) {\n        int a = 5;\n        int b = 3;\n        int resultado = a + b;\n        System.out.println("La suma es: " + resultado);\n    }\n}',
        888),

       (3, 'Multiplicación de números', 'Este programa multiplica dos números',
        E'public class Multiplicar {\n    public static void main(String[] args) {\n        int a = 4;\n        int b = 6;\n        int resultado = a * b;\n        System.out.println("La multiplicación es: " + resultado);\n    }\n}',
        889),

       (4, 'Programa de Fibonacci', 'Este programa imprime los primeros 10 números de la secuencia de Fibonacci',
        E'public class Fibonacci {\n    public static void main(String[] args) {\n        int n1 = 0, n2 = 1, n3;\n        System.out.print("Fibonacci: " + n1 + " " + n2);\n        for(int i = 2; i < 10; ++i) {\n            n3 = n1 + n2;\n            System.out.print(" " + n3);\n            n1 = n2;\n            n2 = n3;\n        }\n    }\n}',
        889),

       (5, 'Calculadora de Factorial', 'Este programa calcula el factorial de un número',
        E'public class Factorial {\n    public static void main(String[] args) {\n        int n = 5;\n        int factorial = 1;\n        for(int i = 1; i <= n; ++i) {\n            factorial *= i;\n        }\n        System.out.println("El factorial de " + n + " es: " + factorial);\n    }\n}',
        889),

       (6, 'Invertir una cadena', 'Este programa invierte una cadena de texto',
        E'public class InvertirCadena {\n    public static void main(String[] args) {\n        String cadena = "Hola";\n        String invertida = "";\n        for(int i = cadena.length() - 1; i >= 0; i--) {\n            invertida += cadena.charAt(i);\n        }\n        System.out.println("Cadena invertida: " + invertida);\n    }\n}',
        888),

       (7, 'Contar palabras en una frase', 'Este programa cuenta las palabras en una frase',
        E'public class ContarPalabras {\n    public static void main(String[] args) {\n        String frase = "Contamos cuantas palabras hay";\n        String[] palabras = frase.split(" ");\n        System.out.println("Número de palabras: " + palabras.length);\n    }\n}',
        888)
    ON CONFLICT (id) DO NOTHING;

-- Comments
INSERT INTO comments (id, program_id, content, created_at, updated_at)
VALUES
    (100, 101, 'Excelente programa, muy útil para aprender Java básico.', '2025-05-21T10:00:00', NULL),
    (202, 101, 'Sería bueno agregar más ejemplos de entrada y salida.', '2025-05-21T10:30:00', NULL),
    (300, 3, 'Me ayudó a entender cómo funcionan los bucles.', '2025-05-21T11:00:00', NULL),
    (400, 4, 'Buena explicación de la secuencia Fibonacci.', '2025-05-21T11:30:00', NULL),
    (500, 5, 'Faltan validaciones en el cálculo del factorial.', '2025-05-21T12:00:00', NULL),
    (600, 6, 'Excelente práctica para manejo de strings.', '2025-05-21T12:30:00', NULL),
    (700, 7, 'Muy claro, pero el método split se puede explicar mejor.', '2025-05-21T13:00:00', NULL)
    ON CONFLICT (id) DO NOTHING;

-- examples
INSERT INTO examples (id, title, description, code, topic, difficulty, createdAt, professor_id)
VALUES
    (100, 'Ejemplo de recursión', 'Función que se llama a sí misma', 'def factorial(n): return 1 if n==0 else n*factorial(n-1)', 'Programación', 'Media', '2024-05-20 10:00:00', 301),
    (200, 'Condicionales en Java', 'Uso de if y else en Java', 'if (x > 0) { System.out.println("Positivo"); }', 'Java', 'Fácil', '2024-05-21 14:30:00', 302)
    ON CONFLICT (id) DO NOTHING;
