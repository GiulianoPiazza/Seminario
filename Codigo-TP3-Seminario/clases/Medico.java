package clases;

//La clase "Médico" representa a un profesional médico de la clinica con atributos como especialidad y una lista de turnos

import java.util.ArrayList;
import java.util.List;

// Clase "Medico" extiende la clase "Usuario"
public class Medico extends Usuario {
    // Atributo para la especialidad del médico
    private String especialidad;
    // Lista para almacenar los turnos atendidos por el médico (a futuro para
    // conexión con base de datos)
    private List<Turno> turnosAtendidos;

    // Constructor que inicializa los datos del médico
    public Medico(int dni, String nombre, String apellido, String especialidad) {
        super(dni, nombre, apellido); // Se llama al constructor de la clase padre "Usuario"
        this.especialidad = especialidad;
        this.turnosAtendidos = new ArrayList<>(); // Inicializamos la lista de turnos atendidos (para futuro para
                                                  // conexión con base de datos)
    }

    // Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turno> getTurnosAtendidos() {
        return turnosAtendidos;
    }

    public void setTurnosAtendidos(List<Turno> turnosAtendidos) {
        this.turnosAtendidos = turnosAtendidos;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Médico: " + nombre + " " + apellido + ", DNI: " + dni + ", Especialidad: " + especialidad);
    }

    // Método para generar un reporte diario de los turnos atendidos
    public Reporte generarReporteDiario() {
        Reporte reporte = new Reporte(this.dni);
        reporte.generar(this.turnosAtendidos); // Pasamos la lista de turnos atendidos al reporte (a futuro para
                                               // conexión con base de datos)
        return reporte;
    }
}
