// La clase `Reporte` representa un informe generado para un médico específico.
// Cada reporte contiene información sobre la fecha de generación, el DNI del médico, el número de pacientes atendidos, 
//y detalles del reporte.
// La clase incluye un contador estático para asignar IDs únicos a cada reporte generado.

package model;

import java.time.LocalDate;
import java.util.List;

public class Reporte {
    private static int contadorReporte = 1; // Contador estático para generar IDs únicos para cada reporte.
    private int idReporte; // ID único del reporte
    private LocalDate fechaGeneracion; // Fecha en que se genera el reporte
    private int dniMedico; // DNI del médico que atendió a los pacientes
    private int pacientesAtendidos; // Número de pacientes atendidos en el reporte
    private String detalles; // Detalles del reporte en formato de texto

    // Constructor que inicializa un nuevo reporte.
    // Asigna un ID único al reporte, establece la fecha de generación y almacena el
    // DNI del médico.
    public Reporte(int dniMedico) {
        this.idReporte = contadorReporte++;
        this.fechaGeneracion = LocalDate.now();
        this.dniMedico = dniMedico;
    }

    // Método para generar el reporte en base a una lista de turnos atendidos.
    // Este método cuenta los pacientes atendidos, crea el detalle del reporte y lo
    // imprime en consola.
    public void generar(List<Turno> turnosAtendidos) {
        this.pacientesAtendidos = turnosAtendidos.size(); // Almacena el número de turnos atendidos.
        StringBuilder sb = new StringBuilder(); // Utiliza un StringBuilder para construir el detalle del reporte.
        System.out.println("---------------------------------------");
        sb.append("---   Reporte Generado el ").append(fechaGeneracion).append("\n");
        sb.append("---   Médico DNI: ").append(dniMedico).append("\n");
        sb.append("---   Pacientes Atendidos: ").append(pacientesAtendidos).append("\n");
        this.detalles = sb.toString(); // Guarda el detalle completo en el atributo `detalles`.
        System.out.println(detalles); // Imprime los detalles del reporte en la consola.

    }
}
