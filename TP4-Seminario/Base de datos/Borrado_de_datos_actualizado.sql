-- Borrar datos de prueba
DELETE FROM Registro_Atencion;
DELETE FROM Turno;
DELETE FROM Administrador;
DELETE FROM Medico;
DELETE FROM Paciente;
DELETE FROM Especialidad;
DELETE FROM Prioridad;
DELETE FROM Reporte;
ALTER TABLE Turno AUTO_INCREMENT = 1; -- Para q los id de turno vuelvan a 1
-- Verificar 
SELECT * FROM Registro_Atencion;
SELECT * FROM Turno;
SELECT * FROM Administrador;
SELECT * FROM Medico;
SELECT * FROM Paciente;
SELECT * FROM Especialidad;
SELECT * FROM Prioridad;
SELECT * FROM Reporte;





