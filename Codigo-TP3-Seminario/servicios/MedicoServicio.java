package servicios;

import clases.Medico;

//La clase "MedicoServicio" administra una lista de objetos `Medico`, lo que permite agregar, buscar,
//editar y eliminar médicos.

import java.util.ArrayList;
import java.util.List;

public class MedicoServicio {
    private List<Medico> medicos = new ArrayList<>(); //Lista de médicos

    // Método para agregar un médico a la lista
    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    // Método para buscar un médico por su DNI
    public Medico buscarMedico(int dni) {
        for (Medico medico : medicos) {
            if (medico.getDni() == dni) {
                return medico;
            }
        }
        return null;
    }

    // Método para editar un médico (nombre, apellido y especialidad)
    public void editarMedico(int dni, String nuevoNombre, String nuevoApellido, String nuevaEspecialidad) {
        Medico medico = buscarMedico(dni);
        if (medico != null) {
            medico.setNombre(nuevoNombre);
            medico.setApellido(nuevoApellido);
            medico.setEspecialidad(nuevaEspecialidad);
            System.out.println("Médico editado exitosamente.");
        } else {
            System.out.println("Médico no encontrado.");
        }
    }

    // Método para eliminar un médico de la lista
    public void eliminarMedico(int dni) {
        Medico medico = buscarMedico(dni);
        if (medico != null) {
            medicos.remove(medico);
            System.out.println("Médico eliminado exitosamente.");
        } else {
            System.out.println("Médico no encontrado.");
        }
    }

    // Método para obtener la lista de médicos
    public List<Medico> getMedicos() {
        return medicos;
    }
}
