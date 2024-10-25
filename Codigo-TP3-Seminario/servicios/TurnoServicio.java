package servicios;

// La clase "TurnoServicio" gestiona la asignación, cancelación y visualización 
//de turnos de pacientes dentro de una lista de turnos.

import clases.Turno;
import clases.ListaTurnos;

public class TurnoServicio {
    private ListaTurnos listaTurnos; // Se hace referencia a la lista de turnos

    // Constructor que inicializa el servicio con una lista de turnos
    public TurnoServicio(ListaTurnos listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    // Método para asignar un turno y agregarlo a la lista
    public void asignarTurno(Turno turno) {
        listaTurnos.agregarTurno(turno);
    }

    // Método para cancelar un turno basado en su código único
    public void cancelarTurno(String codigoUnico) {
        listaTurnos.eliminarTurno(codigoUnico);
    }

    // Método para visualizar la cantidad de pacientes en espera
    public void visualizarPacientesEnEspera(String codigoUnico) {
        int posicion = listaTurnos.obtenerPosicionTurno(codigoUnico); 
        if (posicion != -1) {
            System.out.println("Hay " + posicion + " pacientes delante de usted.");
        } else {
            System.out.println("Turno no encontrado.");
        }
    }
}
