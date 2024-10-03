SELECT 
    M.nombre AS 'Nombre Médico',
    M.apellido AS 'Apellido Médico',
    E.nombre AS 'Especialidad',
    COUNT(RA.paciente_DNI) AS 'Pacientes Atendidos'
FROM 
    Medico M
JOIN 
    Especialidad E ON M.especialidad_ID = E.ID_ESPECIALIDAD
LEFT JOIN 
    Turno T ON M.DNI = T.medico_DNI
LEFT JOIN 
    Registro_Atencion RA ON T.ID_TURNO = RA.turno_ID
GROUP BY 
    M.DNI, E.nombre
ORDER BY 
    M.apellido, M.nombre;
