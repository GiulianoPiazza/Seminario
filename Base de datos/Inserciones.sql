-- Inserción de datos en la tabla Paciente
INSERT INTO Paciente (DNI, nombre, apellido, telefono, email) VALUES
(20345678, 'Giuliano', 'Pérez', '123456789', 'giuliano.perez@gmail.com'),
(20765432, 'Karina', 'Gómez', '987654321', 'karina.gomez@gmail.com'),
(21098765, 'Martín', 'Martínez', '456789123', 'martin.martinez@gmail.com'),
(21567890, 'Pablo', 'López', '321654987', 'pablo.lopez@gmail.com'),
(22012345, 'Sofía', 'Fernández', '654321789', 'sofia.fernandez@gmail.com');

-- Inserción de datos en la tabla Especialidad
INSERT INTO Especialidad (ID_ESPECIALIDAD, nombre) VALUES
(1, 'Medicina General'),
(2, 'Pediatría'),
(3, 'Ginecología'),
(4, 'Cardiología'),
(5, 'Dermatología'),
(6, 'Oncología'),
(7, 'Gastroenterología'),
(8, 'Urología');

-- Inserción de datos en la tabla Prioridad
INSERT INTO Prioridad (ID_PRIORIDAD, descripcion) VALUES
(1, 'Emergencia (Nivel 1): Atención inmediata.'),
(2, 'Urgencia (Nivel 2): Atención pronta.'),
(3, 'Patología común (Nivel 3): Puede esperar.');

-- Inserción de datos en la tabla Medico
INSERT INTO Medico (DNI, nombre, apellido, especialidad_ID, paciente_DNI, matricula) VALUES
(12345678, 'Dr. Carlos', 'López', 1, 20345678, 'M12345'),
(23456789, 'Dra. María', 'Sánchez', 2, 20765432, 'M67890'),
(34567890, 'Dr. Jorge', 'Ramírez', 3, 21098765, 'M54321'),
(45678901, 'Dra. Laura', 'Martínez', 4, 21567890, 'M67812'),
(56789012, 'Dr. Pablo', 'González', 5, 22012345, 'M78901'),
(67890123, 'Dra. Ana', 'Torres', 6, 20345678, 'M89012'),
(78901234, 'Dr. Manuel', 'Hernández', 7, 20765432, 'M90123'),
(89012345, 'Dra. Lucía', 'Díaz', 8, 21098765, 'M01234');

-- Inserción de datos en la tabla Turno
INSERT INTO Turno (fecha, prioridad_ID, estado, paciente_DNI, medico_DNI) VALUES
('2024-10-02 10:00:00', 1, 'atendido', 20345678, 12345678),
('2024-10-02 11:00:00', 2, 'atendido', 20765432, 23456789),
('2024-10-02 12:00:00', 3, 'cancelado', 21098765, 34567890),
('2024-10-02 13:00:00', 1, 'atendido', 21567890, 45678901),
('2024-10-02 14:00:00', 2, 'pendiente', 22012345, 56789012),
('2024-10-02 15:00:00', 3, 'atendido', 20345678, 67890123),
('2024-10-02 16:00:00', 1, 'pendiente', 20765432, 78901234);

-- Inserción de datos en la tabla Administrador
INSERT INTO Administrador (DNI, nombre, apellido, medico_DNI, turno_ID) VALUES
(34567890, 'Laura', 'Martínez', 12345678, 1),
(45678901, 'Ricardo', 'Gutiérrez', 23456789, 2);

-- Inserción de datos en la tabla Registro_Atencion
INSERT INTO Registro_Atencion (ID_REGISTRO_ATENCION, turno_ID, medico_DNI, paciente_DNI, fecha_atencion, diagnostico) VALUES
(1, 1, 12345678, 20345678, '2024-10-02 10:30:00', 'Hipertensión'),
(2, 2, 23456789, 20765432, '2024-10-02 11:30:00', 'Gripe'),
(3, 4, 45678901, 21567890, '2024-10-02 13:30:00', 'Control prenatal'),
(4, 6, 67890123, 20345678, '2024-10-02 15:30:00', 'Cálculo renal');

-- Inserción de datos en la tabla Reporte
INSERT INTO Reporte (ID_REPORTE, fecha_generacion, medico_DNI, pacientes_atendidos) VALUES
(1, '2024-10-02 12:00:00', 12345678, 1),
(2, '2024-10-02 12:00:00', 23456789, 1),
(3, '2024-10-02 12:00:00', 45678901, 1),
(4, '2024-10-02 12:00:00', 67890123, 1);
