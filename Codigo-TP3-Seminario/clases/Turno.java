package clases;

//La clase `Turno` representa una cita médica en la clinica con identificación única, información del paciente y del médico,
//nivel de prioridad, estado y fecha.


import java.time.LocalDateTime;


public class Turno {
    private static int contadorTurno = 1; // Contador estático para asignar ID únicos a los turnos
    private int idTurno;
    private String codigoUnico;
    private int dniPaciente;
    private int dniMedico;
    private int prioridad; // 1, 2 o 3
    private String estado; // Estado del turno: 'pendiente', 'atendido', 'cancelado'
    private LocalDateTime fecha; //Fecha y hora del turno

    // Constructor que asigna un nuevo turno
    public Turno(int dniPaciente, int dniMedico, int prioridad) {
        this.idTurno = contadorTurno++;
        this.codigoUnico = generarCodigoUnico(); // Genera un código único
        this.dniPaciente = dniPaciente;
        this.dniMedico = dniMedico;
        this.prioridad = prioridad;
        this.estado = "pendiente"; //El estado inicial es pendiente
        this.fecha = LocalDateTime.now();
    }

    // Método para generar un código único para cada turno
    private String generarCodigoUnico() {
        return "T" + idTurno; // Código único secuencial que empiece con la "T" de Turno
    }

    // Getters y Setters
    public int getIdTurno() {
        return idTurno;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public int getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(int dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public int getDniMedico() {
        return dniMedico;
    }

    public void setDniMedico(int dniMedico) {
        this.dniMedico = dniMedico;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    // Método para obtener los detalles del turno
    public void obtenerDetalles() {
        System.out.println("---------------------------");

        System.out.println("--- Detalles del Turno: ---");
        System.out.println("---------------------------");
        System.out.println("-- Turno ID: " + idTurno );
        System.out.println("-- Código: " + codigoUnico);
        System.out.println("-- Paciente DNI: " + dniPaciente);
        System.out.println("-- Médico DNI: " + dniMedico);
        System.out.println("-- Prioridad: " + prioridad);
        System.out.println("-- Estado: " + estado);
        System.out.println("-- Fecha: " + fecha.toLocalDate());
        System.out.println("---------------------------");
    }
    
    
    // Métodos (que seran utilizados mas adelante con la base de datos)
    public void asignar() {
        this.estado = "pendiente";
    }

    public void cancelar() {
        this.estado = "cancelado";
    }
}
