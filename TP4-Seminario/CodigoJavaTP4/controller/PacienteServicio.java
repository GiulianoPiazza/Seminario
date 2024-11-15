// La clase `PacienteServicio` maneja las operaciones relacionadas con los pacientes en la base de datos.
// Incluye métodos para agregar pacientes, buscar pacientes y generar un código de turno único.


package controller;

import model.Paciente;
import java.sql.*;

public class PacienteServicio {

    // Contador incremental para generar códigos de turno únicos para cada paciente.
    private static int contadorTurno = 1; 

    // Genera un código de turno único utilizando el contador.
    public String generarCodigoTurno() {
        return "T-" + (contadorTurno++); // Ejemplo: "T-1", "T-2", etc.
    }

    // Agrega un nuevo paciente a la base de datos.
    public void agregarPaciente(Paciente paciente) {
        String sql = "INSERT INTO Paciente (DNI, nombre, apellido, telefono, email, especialidad_ID) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); // Establece la conexión.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Asigna los valores del paciente a los parámetros de la consulta SQL.
            pstmt.setInt(1, paciente.getDni());
            pstmt.setString(2, paciente.getNombre());
            pstmt.setString(3, paciente.getApellido());
            pstmt.setString(4, paciente.getTelefono());
            pstmt.setString(5, paciente.getEmail());
            pstmt.setInt(6, paciente.getEspecialidadId()); // Guardar especialidad_ID

            pstmt.executeUpdate(); // Ejecuta la consulta para insertar el paciente en la base de datos.
            System.out.println("Paciente agregado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar paciente: " + e.getMessage());
        }
    }

    // Busca un paciente por su DNI y devuelve un objeto `Paciente` si existe.
    public Paciente buscarPaciente(int dni) {
        String sql = "SELECT * FROM Paciente WHERE DNI = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, dni); // Asigna el DNI a la consulta SQL.
            ResultSet rs = pstmt.executeQuery(); // Ejecuta la consulta y obtiene el resultado.

            // Si el paciente existe, crea un objeto `Paciente` con los datos obtenidos.
            if (rs.next()) {
                return new Paciente(
                    rs.getInt("DNI"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getInt("especialidad_ID"), // Obtener especialidad_ID
                    generarCodigoTurno()
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar paciente: " + e.getMessage());
        }
        return null;
    }
}
