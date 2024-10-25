package clases;

// La clase `ListaTurnos` administra una lista de objetos `Turno`, lo que permite agregar, eliminar, ordenar
//y recuperar objetos de turno (Por ahora, toda la información de los turnos se guarda en memoria (en la lista turnos), 
//pero en el futuro, al integrar una base de datos, los turnos se almacenarán de manera permanente)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Lista que almacena los turnos de los pacientes
public class ListaTurnos {
    private List<Turno> turnos;

    // Constructor que inicializa la lista de turnos vacía
    public ListaTurnos() {
        this.turnos = new ArrayList<>();
    }

    // Método para obtener la lista de turnos
    public List<Turno> getTurnos() {
        return turnos;
    }

    // Método para agregar un turno a la lista y ordenarla por prioridad y fecha
    public void agregarTurno(Turno turno) {
        turnos.add(turno);
        ordenarTurnos();
        System.out.println("Turno agregado correctamente. Código Único: " + turno.getCodigoUnico());
    }

    // Método para eliminar un turno de la lista mediante un código único
    public void eliminarTurno(String codigoUnico) {
        for (Turno turno : turnos) {
            if (turno.getCodigoUnico().equals(codigoUnico)) {   // Se verifica si el código único del turno coincide con el proporcionado
                turnos.remove(turno);
                System.out.println("Turno eliminado correctamente.");
                return; // Salir del método después de eliminar
            }
        }
        System.out.println("Turno no encontrado."); // Mensaje si no se encuentra el turno
    }
    
    // Método para devolver la lista de turnos ordenada
    public List<Turno> obtenerTurnos() {
        return turnos;
    }

    // Método privado para ordenar los turnos por prioridad y fecha
    private void ordenarTurnos() {
        turnos.sort(Comparator.comparingInt(Turno::getPrioridad)
                .thenComparing(Turno::getFecha));
    }

    // Método para obtener la posición de un turno en la lista mediante su código único
    public int obtenerPosicionTurno(String codigoUnico) {
        for (int i = 0; i < turnos.size(); i++) {
            if (turnos.get(i).getCodigoUnico().equals(codigoUnico)) {
                return i;
            }
        }
        return -1; // Retorna -1 si el turno no es encontrado
    }

}
