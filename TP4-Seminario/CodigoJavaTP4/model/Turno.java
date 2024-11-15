// La clase `Turno` representa una cita o turno de un paciente con un médico.
// Cada turno incluye información como el ID del turno, el DNI del paciente, el DNI del médico, la prioridad, el estado y la fecha.


package model;

import java.time.LocalDateTime;

public class Turno {
    private int idTurno;
    private int dniPaciente;
    private int dniMedico;
    private int prioridadId;
    private String estado;
    private LocalDateTime fecha;

     // Constructor que inicializa un turno con todos sus atributos.
    public Turno(int idTurno, int dniPaciente, int dniMedico, int prioridadId, String estado, LocalDateTime fecha) {
        this.idTurno = idTurno;
        this.dniPaciente = dniPaciente;
        this.dniMedico = dniMedico;
        this.prioridadId = prioridadId;
        this.estado = estado;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdTurno() {
        return idTurno;
    }

    public int getDniPaciente() {
        return dniPaciente;
    }

    public int getDniMedico() {
        return dniMedico;
    }

    public int getPrioridadId() {
        return prioridadId;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
