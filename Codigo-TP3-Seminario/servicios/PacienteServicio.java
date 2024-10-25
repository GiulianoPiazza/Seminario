package servicios;

// La clase `PacienteServicio` es responsable de gestionar todas las operaciones relacionadas con los pacientes.
// Esta clase contiene métodos para agregar, eliminar y buscar pacientes, así como para solicitar y cancelar turnos.
// Una vez que el sistema se conecte a la base de datos, esta clase servirá como intermediaria para interactuar
// con los datos de los pacientes y los turnos almacenados en la base de datos.

import clases.Paciente;
import clases.Turno;
import clases.ListaTurnos;

import java.util.ArrayList;
import java.util.List;

public class PacienteServicio {
    private List<Paciente> pacientes; // Lista de pacientes registrados
    private ListaTurnos listaTurnos; // Lista de turnos gestionados

    // Constructor que recibe una lista de turnos. Esta lista es necesaria para gestionar los turnos solicitados por los pacientes.
    public PacienteServicio(ListaTurnos listaTurnos) {
        this.pacientes = new ArrayList<>(); // Se nicializa la lista de pacientes como un ArrayList vacío.
        this.listaTurnos = listaTurnos; // Se asocia la lista de turnos pasada como parámetro al atributo local.
    }

    // Método para agregar un nuevo paciente a la lista de pacientes.
    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente agregado correctamente.");
    }

    // Método para eliminar un paciente de la lista utilizando su DNI.
    public void eliminarPaciente(int dniPaciente) {
        for (Paciente paciente : pacientes) {
            if (paciente.getDni() == dniPaciente) {
                pacientes.remove(paciente);
                System.out.println("Paciente eliminado correctamente.");
                return; // Sale del método después de eliminar al paciente.
            }
        }
        System.out.println("Paciente no encontrado.");
    }

    // Método para buscar un paciente por su DNI.
    public Paciente buscarPaciente(int dniPaciente) {
        for (Paciente paciente : pacientes) {
            if (paciente.getDni() == dniPaciente) {
                return paciente; // Retorna el paciente encontrado
            }
        }
        return null; // Retorna null si no se encuentra
    }

    // Método para solicitar un turno y asignarlo al paciente
    public void solicitarTurno(Paciente paciente, int dniMedico, int prioridad) {
        Turno turno = new Turno(paciente.getDni(), dniMedico, prioridad);
        listaTurnos.agregarTurno(turno); // Agrega el turno a la lista de turnos
    }

    // Método para cancelar un turno basado en su código único.
    public void cancelarTurno(String codigoUnico) {
        listaTurnos.eliminarTurno(codigoUnico);
    }

    // Método para ver cuántos pacientes están delante de un paciente en la lista de espera, utilizando su código único de turno.
    public void verTurnosEnEspera(String codigoUnico) {
        int posicion = listaTurnos.obtenerPosicionTurno(codigoUnico);
        if (posicion != -1) {
            System.out.println("Hay " + posicion + " pacientes delante de usted.");
        } else {
            System.out.println("Turno no encontrado.");
        }
    }

    // Método para obtener la lista de todos los pacientes registrados.
    public List<Paciente> getPacientes() {
        return pacientes;
    }
}
