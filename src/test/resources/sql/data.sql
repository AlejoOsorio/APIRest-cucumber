-- Professors
insert into professor (id, name, lastName, identification, email, birthDate, phoneNumber)
values(215, 'Juan', 'Garcia', '3698754', 'juan@gmail.com', '2000-09-19', '3669554875')
    ON CONFLICT (id) DO NOTHING;

insert into professor (id, name, lastName, identification, email, birthDate, phoneNumber)
values(10, 'Mario', 'Morales', '369823754', 'mario@gmail.com', '1998-02-15', '65988888')
    ON CONFLICT (id) DO NOTHING;

insert into professor (id, name, lastName, identification, email, birthDate, phoneNumber)
values(102, 'Fernando', 'Arias', '102', 'fernando@gmail.com', '1998-02-15', '651988888')
    ON CONFLICT (id) DO NOTHING;

insert into professor (id, name, lastName, identification, email, birthDate, phoneNumber)
values(105, 'stiven', 'Carmelo', '10242', 'stiven@gmail.com', '2002-02-15', '6088888')
    ON CONFLICT (id) DO NOTHING;

-- Students
insert into students (id, name, lastname, identification, email, birthdate, semester)
values(123, 'andres', 'Alzate', '102422', 'andres@gmail.com', '2000-02-15', 3)
    ON CONFLICT (id) DO NOTHING;

insert into students (id, name, lastname, identification, email, birthdate, semester)
values(321, 'maria', 'Alzate', '1022422', 'marias@gmail.com', '1999-02-15', 3)
    ON CONFLICT (id) DO NOTHING;

insert into students (id, name, lastname, identification, email, birthdate, semester)
values(333, 'pedro', 'Zuluaga', '333', 'pedro@gmail.com', '2002-02-15', 1)
    ON CONFLICT (id) DO NOTHING;

insert into students (id, name, lastname, identification, email, birthdate, semester)
values(428, 'andres', 'Garcia', '1024222', 'andresgar@gmail.com', '2004-02-15', 2)
    ON CONFLICT (id) DO NOTHING;

-- Subjects

INSERT INTO subject (id, name, description, credits)
VALUES (555, 'Programación I', 'Introducción a la programación con Java', 3)
    ON CONFLICT (id) DO NOTHING;

insert into subject (id, credits, description, name)
values(1, 3, 'la base de las matematicas', 'Matematicas generales')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO subject (id, name, description, credits)
VALUES (466, 'Estructuras de Datos', 'Estudio de estructuras fundamentales como listas, pilas y árboles', 4)
    ON CONFLICT (id) DO NOTHING;

INSERT INTO subject (id, name, description, credits)
VALUES (35, 'Algoritmos y Estructuras de Datos', 'Estudio de algoritmos fundamentales y estructuras de datos avanzadas', 4)
    ON CONFLICT (id) DO NOTHING;