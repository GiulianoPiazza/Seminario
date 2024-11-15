// La clase `AdministradorServicio` permite gestionar las operaciones relacionadas con el administrador y los médicos.
// Esta clase facilita la búsqueda de administradores y la administración de la lista de médicos usando métodos para agregar, editar, eliminar y obtener médicos.

package controller;

import model.Administrador;
import model.Medico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministradorServicio {

    // `medicoServicio` es una instancia de `MedicoServicio` que se usa para delegar
    // operaciones de médico.
    private MedicoServicio medicoServicio = new MedicoServicio();

    // Método `buscarAdministrador` que realiza una búsqueda en la base de datos
    // para encontrar un administrador específico por DNI.
    public Administrador buscarAdministrador(int dni) {
        String sql = "SELECT * FROM Administrador WHERE DNI = ?";

        // Uso de `try-with-resources` para manejar la conexión y asegurarse de cerrarla
        // al finalizar.
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Si hay un resultado, crea un nuevo objeto `Administrador` con los datos
            // obtenidos.
            pstmt.setInt(1, dni);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Administrador(
                        rs.getInt("DNI"),
                        rs.getString("nombre"),
                        rs.getString("apellido"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar administrador: " + e.getMessage());
        }
        return null;
    }

    // Método para agregar un nuevo médico llamando al método correspondiente en
    // `MedicoServicio`.
    public void agregarMedico(Medico medico) {
        medicoServicio.agregarMedico(medico);
    }

    // Método para editar un médico existente usando `MedicoServicio`.
    public void editarMedico(Medico medico) {
        medicoServicio.editarMedico(medico);
    }

    // Método para eliminar un médico, especificando el DNI, y delegando en
    // `MedicoServicio`.
    public void eliminarMedico(int dni) {
        medicoServicio.eliminarMedico(dni);
    }

    // Método `obtenerMedicos` que consulta todos los médicos de la base de datos y
    // los devuelve en una lista.
    public List<Medico> obtenerMedicos() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM Medico";

        // Uso de `try-with-resources` para manejar la conexión y el `Statement`.
        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // Recorre el resultado y crea objetos `Medico` para cada registro encontrado.
            while (rs.next()) {
                Medico medico = new Medico(
                        rs.getInt("DNI"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("especialidad_ID"),
                        rs.getString("matricula"));
                medicos.add(medico); // Añade cada `Medico` a la lista `medicos`.
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener lista de médicos: " + e.getMessage());
        }

        return medicos; // Retorna la lista de médicos obtenidos de la base de datos.
    }
}
