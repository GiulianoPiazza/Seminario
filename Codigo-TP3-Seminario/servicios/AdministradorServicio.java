package servicios;

//La clase "AdministradorServicio" administra a los administradores e interactúa con la clase "MedicoServicio"
//para manejar operaciones relacionadas con administradores y médicos.

import clases.Administrador;
import clases.Medico;
import java.util.ArrayList;
import java.util.List;

public class AdministradorServicio {
    private List<Administrador> administradores; // Lista de administradores registrados
    private MedicoServicio medicoServicio; // Servicio que gestiona a los médicos

    // Constructor que inicializa la lista de administradores y el servicio de
    // médicos
    public AdministradorServicio(MedicoServicio medicoServicio) {
        this.administradores = new ArrayList<>();
        this.medicoServicio = medicoServicio; // Se inicializa la referencia al servicio de médicos
    }

    // Método para agregar un administrador a la lista
    public void agregarAdministrador(Administrador admin) {
        administradores.add(admin);
    }

    // Método para agregar un nuevo médico usando el servicio de médicos
    public void agregarMedico(Medico nuevoMedico) {
        medicoServicio.agregarMedico(nuevoMedico); //Se llama al servicio de médicos
    }

    // Método para buscar un administrador por su DNI
    public Administrador buscarAdministrador(int dniAdministrador) {
        for (Administrador admin : administradores) {
            if (admin.getDni() == dniAdministrador) {
                return admin; // Retorna el administrador encontrado
            }
        }
        return null; // Retorna null si no se encuentra
    }

}
