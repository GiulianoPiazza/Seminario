package clases;


//La clase `Reporte` representa un reporte generado por un médico de la clinica, que contiene información como
//fecha de generación, identificación del médico, número de pacientes atendidos y detalles.

import java.time.LocalDate;
import java.util.List;

// Atributos estáticos y de instancia para manejar los reportes
public class Reporte {
    private static int contadorReporte = 1; //Genera IDs únicos
    private int idReporte;
    private LocalDate fechaGeneracion;  // Fecha en la que se genera el reporte
    private int dniMedico;
    private int pacientesAtendidos; // Cantidad de pacientes atendidos por el médico
    private String detalles; // Detalles del reporte

    // Constructor para inicializar el reporte con el DNI del médico
    public Reporte(int dniMedico) {
        this.idReporte = contadorReporte++;
        this.fechaGeneracion = LocalDate.now(); 
        this.dniMedico = dniMedico;
    }

    // Getters y Setters
    public int getIdReporte() {
        return idReporte;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public int getDniMedico() {
        return dniMedico;
    }

    public int getPacientesAtendidos() {
        return pacientesAtendidos;
    }

    public void setPacientesAtendidos(int pacientesAtendidos) {
        this.pacientesAtendidos = pacientesAtendidos;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    // Método para generar el reporte basado en la lista de turnos atendidos (pero por el momento no esta la opcion de atender pacientes)
    public void generar(List<Turno> turnosAtendidos) {
        this.pacientesAtendidos = turnosAtendidos.size();
        StringBuilder sb = new StringBuilder();
        
        // Se muestra el detalle del reporte
        sb.append("Reporte Generado el ").append(fechaGeneracion).append("\n");
        sb.append("Médico DNI: ").append(dniMedico).append("\n");
        sb.append("Pacientes Atendidos: ").append(pacientesAtendidos).append("\n");
        
        this.detalles = sb.toString();
        System.out.println(detalles); //Se muestra el reporte generado 
    }
}
