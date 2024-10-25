package clases;


//La clase `Administrador` en Java representa un usuario administrador con métodos para gestionar médicos,
//incluyendo agregar, editar y eliminar.

import java.util.List;
import funcionesUtiles.FuncionesDeEntradas;

public class Administrador extends Usuario {
    // Constructor de la clase "Administrador" que hereda de la clase "Usuario"
    public Administrador(int dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }

    // Método para mostrar la información del "Administrador"
    @Override
    public void mostrarInfo() {
        System.out.println("Administrador: " + nombre + " " + apellido + ", DNI: " + dni);
    }

    // Método para agregar un nuevo médico a la lista de médicos
    public void agregarMedico(Medico medico, List<Medico> listaMedicos) {
        listaMedicos.add(medico);
        System.out.println("Médico agregado correctamente.");
    }

    // Método para editar un médico existente basado en su DNI
    public void editarMedico(int dniMedico, List<Medico> listaMedicos) {
        for (Medico med : listaMedicos) {
            if (med.getDni() == dniMedico) { 

                //Se ingresan los datos para editar
                System.out.println("Ingrese el nuevo nombre:");
                String nuevoNombre = FuncionesDeEntradas.leerString();
                System.out.println("Ingrese el nuevo apellido:");
                String nuevoApellido = FuncionesDeEntradas.leerString();
                System.out.println("Ingrese la nueva especialidad:");
                String nuevaEspecialidad = FuncionesDeEntradas.leerString();
                // Se actualizan los datos del médico
                med.setNombre(nuevoNombre);
                med.setApellido(nuevoApellido);
                med.setEspecialidad(nuevaEspecialidad);
                System.out.println("Médico editado correctamente.");
                return;
            }
        }
        System.out.println("Médico no encontrado.");
    }

    // Método para eliminar un médico de la lista
    public void eliminarMedico(int dniMedico, List<Medico> listaMedicos) {
        Medico medicoAEliminar = null;
        for (Medico med : listaMedicos) {
            if (med.getDni() == dniMedico) {
                medicoAEliminar = med;
                break;
            }
        }
        if (medicoAEliminar != null) {
            listaMedicos.remove(medicoAEliminar);
            System.out.println("Médico eliminado correctamente.");
        } else {
            System.out.println("Médico no encontrado.");
        }
    }

    // Método para ver el registro de todos los turnos asignados 
    public void verRegistroTurnos(List<Turno> listaTurnos) {  
        for (Turno tur : listaTurnos) {
            tur.obtenerDetalles(); // Se llamamos al método "obtenerDetalles()"" de la clase "Turno"
        }
    }
}
