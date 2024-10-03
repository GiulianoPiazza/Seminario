SELECT 
    P.nombre AS 'Nombre Paciente',
    P.apellido AS 'Apellido Paciente',
    M.nombre AS 'Nombre Médico',
    M.apellido AS 'Apellido Médico',
    T.fecha AS 'Fecha Turno',
    T.estado AS 'Estado Turno',
    PR.descripcion AS 'Descripción Prioridad'
FROM 
    Turno T
JOIN 
    Paciente P ON T.paciente_DNI = P.DNI
JOIN 
    Medico M ON T.medico_DNI = M.DNI
JOIN 
    Prioridad PR ON T.prioridad_ID = PR.ID_PRIORIDAD
WHERE 
    PR.descripcion LIKE '%Urgencia%';  -- Filtra por prioridad de urgencia
