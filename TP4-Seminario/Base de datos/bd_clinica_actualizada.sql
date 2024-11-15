-- Creación de la base de datos y uso
CREATE DATABASE bd_clinicaCBA;
USE bd_clinicaCBA;


CREATE TABLE Especialidad (
    ID_ESPECIALIDAD INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(100) NOT NULL
);

-- Creación de las tablas
CREATE TABLE Paciente (
    DNI INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    email VARCHAR(100),
    especialidad_ID INT NOT NULL,
    FOREIGN KEY (especialidad_ID) REFERENCES Especialidad(ID_ESPECIALIDAD)
);

CREATE TABLE Prioridad (
    ID_PRIORIDAD INT PRIMARY KEY NOT NULL,
    descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE Medico (
    DNI INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    especialidad_ID INT NOT NULL,
    matricula VARCHAR(50) NOT NULL,
    FOREIGN KEY (especialidad_ID) REFERENCES Especialidad(ID_ESPECIALIDAD)
);

CREATE TABLE Turno (
    ID_TURNO INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    fecha DATETIME,
    prioridad_ID INT NOT NULL,
    estado ENUM('pendiente', 'atendido', 'cancelado') NOT NULL,
    paciente_DNI INT NOT NULL,
    medico_DNI INT NOT NULL,
    FOREIGN KEY (prioridad_ID) REFERENCES Prioridad(ID_PRIORIDAD),
    FOREIGN KEY (paciente_DNI) REFERENCES Paciente(DNI),
    FOREIGN KEY (medico_DNI) REFERENCES Medico(DNI) ON DELETE CASCADE
);

CREATE TABLE Administrador (
    DNI INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    medico_DNI INT,
    turno_ID INT,
    FOREIGN KEY (medico_DNI) REFERENCES Medico(DNI) ON DELETE SET NULL,
    FOREIGN KEY (turno_ID) REFERENCES Turno(ID_TURNO) ON DELETE SET NULL
);

CREATE TABLE Registro_Atencion (
    ID_REGISTRO_ATENCION INT PRIMARY KEY NOT NULL,
    turno_ID INT NOT NULL,
    medico_DNI INT NOT NULL,
    paciente_DNI INT NOT NULL,
    fecha_atencion DATETIME,
    diagnostico VARCHAR(255),
    FOREIGN KEY (turno_ID) REFERENCES Turno(ID_TURNO) ON DELETE CASCADE,
    FOREIGN KEY (medico_DNI) REFERENCES Medico(DNI) ON DELETE CASCADE,
    FOREIGN KEY (paciente_DNI) REFERENCES Paciente(DNI)
);

CREATE TABLE Reporte (
    ID_REPORTE INT PRIMARY KEY NOT NULL,
    fecha_generacion DATETIME,
    medico_DNI INT NOT NULL,
    pacientes_atendidos INT,
    FOREIGN KEY (medico_DNI) REFERENCES Medico(DNI) ON DELETE CASCADE
);