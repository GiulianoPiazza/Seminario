SELECT 
    P.nombre AS 'Nombre Paciente',
    P.apellido AS 'Apellido Paciente',
    M.nombre AS 'Nombre Médico',
    M.apellido AS 'Apellido Médico',
    T.fecha AS 'Fecha Turno',
    T.estado AS 'Estado Turno',
    RA.fecha_atencion AS 'Fecha Atención',
    RA.diagnostico AS 'Diagnóstico'
FROM 
    Turno T
JOIN 
    Paciente P ON T.paciente_DNI = P.DNI
JOIN 
    Medico M ON T.medico_DNI = M.DNI
LEFT JOIN 
    Registro_Atencion RA ON T.ID_TURNO = RA.turno_ID
WHERE 
    T.estado = 'atendido';
    
    
    