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

-- Inserción de datos en la tabla Paciente
INSERT INTO Paciente (DNI, nombre, apellido, telefono, email, especialidad_ID) VALUES
(20345678, 'Giuliano', 'Pérez', '123456789', 'giuliano.perez@gmail.com', 1),
(20765432, 'Karina', 'Gómez', '987654321', 'karina.gomez@gmail.com', 2),
(21098765, 'Martín', 'Martínez', '456789123', 'martin.martinez@gmail.com', 3),
(21567890, 'Pablo', 'López', '321654987', 'pablo.lopez@gmail.com', 4),
(22012345, 'Sofía', 'Fernández', '654321789', 'sofia.fernandez@gmail.com', 5);

-- Inserción de datos en la tabla Prioridad
INSERT INTO Prioridad (ID_PRIORIDAD, descripcion) VALUES
(1, 'Emergencia (Nivel 1): Atención inmediata.'),
(2, 'Urgencia (Nivel 2): Atención pronta.'),
(3, 'Patología común (Nivel 3): Puede esperar.');

-- Inserción de datos en la tabla Medico
INSERT INTO Medico (DNI, nombre, apellido, especialidad_ID, matricula) VALUES
(12345678, 'Dr. Carlos', 'López', 1, 'M12345'),
(23456789, 'Dra. María', 'Sánchez', 2, 'M67890'),
(34567890, 'Dr. Jorge', 'Ramírez', 3, 'M54321'),
(45678901, 'Dra. Laura', 'Martínez', 4, 'M67812'),
(56789012, 'Dr. Pablo', 'González', 5, 'M78901'),
(67890123, 'Dra. Ana', 'Torres', 6, 'M89012'),
(78901234, 'Dr. Manuel', 'Hernández', 7, 'M90123'),
(89012345, 'Dra. Lucía', 'Díaz', 8, 'M01234');

-- Inserción de datos en la tabla Turno
INSERT INTO Turno (fecha, prioridad_ID, estado, paciente_DNI, medico_DNI) VALUES
('2024-11-02 10:00:00', 1, 'atendido', 20345678, 12345678),
('2024-11-02 11:00:00', 2, 'atendido', 20765432, 23456789),
('2024-11-02 12:00:00', 3, 'cancelado', 21098765, 34567890),
('2024-11-02 13:00:00', 1, 'atendido', 21567890, 45678901),
('2024-11-02 14:00:00', 2, 'pendiente', 22012345, 56789012),
('2024-11-02 15:00:00', 3, 'atendido', 20345678, 67890123),
('2024-11-02 16:00:00', 1, 'pendiente', 20765432, 78901234),
('2024-11-03 09:00:00', 1, 'atendido', 20345678, 12345678),
('2024-11-03 10:00:00', 2, 'pendiente', 20765432, 23456789),
('2024-11-03 11:00:00', 3, 'atendido', 21098765, 34567890),
('2024-11-03 12:00:00', 1, 'cancelado', 21567890, 45678901),
('2024-11-03 13:00:00', 2, 'atendido', 22012345, 56789012),
('2024-11-03 14:00:00', 3, 'pendiente', 20345678, 67890123),
('2024-11-03 15:00:00', 1, 'atendido', 20765432, 78901234),
('2024-11-04 09:30:00', 2, 'atendido', 21098765, 12345678),
('2024-11-04 10:30:00', 3, 'cancelado', 21567890, 23456789),
('2024-11-04 11:30:00', 1, 'pendiente', 22012345, 34567890),
('2024-11-05 11:00:00', 1, 'atendido', 20345678, 67890123),
('2024-11-05 11:30:00', 3, 'atendido', 20765432, 78901234),
('2024-11-05 12:00:00', 2, 'atendido', 21098765, 12345678),
('2024-11-05 12:30:00', 1, 'atendido', 21567890, 23456789),
('2024-11-05 13:00:00', 3, 'atendido', 22012345, 34567890);


-- Inserción de datos en la tabla Administrador
INSERT INTO Administrador (DNI, nombre, apellido, medico_DNI, turno_ID) VALUES
(34567890, 'Laura', 'Martínez', 12345678 , 1),  
(45678901, 'Ricardo', 'Gutiérrez', 23456789 , 2);

-- Inserción de datos en la tabla Registro_Atencion
INSERT INTO Registro_Atencion (ID_REGISTRO_ATENCION, turno_ID, medico_DNI, paciente_DNI, fecha_atencion, diagnostico) VALUES
(1, 1, 12345678, 20345678, '2024-10-02 10:30:00', 'Hipertensión'),
(2, 2, 23456789, 20765432, '2024-10-02 11:30:00', 'Gripe'),
(3, 4, 45678901, 21567890, '2024-10-02 13:30:00', 'Control prenatal'),
(4, 6, 67890123, 20345678, '2024-10-02 15:30:00', 'Cálculo renal'),
(5, 5, 56789012, 22012345, '2024-11-03 14:00:00', 'Consulta de rutina'),
(6, 7, 67890123, 20345678, '2024-11-03 15:30:00', 'Dolor abdominal'),
(7, 8, 78901234, 21567890, '2024-11-04 09:00:00', 'Chequeo general');

-- Inserción de datos en la tabla Reporte
INSERT INTO Reporte (ID_REPORTE, fecha_generacion, medico_DNI, pacientes_atendidos) VALUES
(1, '2024-11-01 10:00:00', 12345678, 5),
(2, '2024-11-01 11:00:00', 23456789, 3),
(3, '2024-11-01 12:00:00', 34567890, 4);