// La clase `MedicoServicio` permite realizar operaciones CRUD para los médicos y gestionar sus turnos.
// Incluye métodos para agregar, buscar, editar, eliminar médicos y generar reportes diarios basados en los turnos atendidos.

package controller;

import model.Medico;
import model.Paciente;
import model.Reporte;
import model.Turno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoServicio {

    // Instancia de `PacienteServicio` para generar códigos de turno únicos.
    private PacienteServicio pacienteServicio = new PacienteServicio(); // Instancia para generar código de turno

    // Método `agregarMedico` para insertar un nuevo médico en la base de datos.
    public void agregarMedico(Medico medico) {
        String sql = "INSERT INTO Medico (DNI, nombre, apellido, especialidad_ID, matricula) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Asigna cada valor del médico en la consulta.
            pstmt.setInt(1, medico.getDni());
            pstmt.setString(2, medico.getNombre());
            pstmt.setString(3, medico.getApellido());
            pstmt.setInt(4, medico.getEspecialidadId());
            pstmt.setString(5, medico.getMatricula());
            pstmt.executeUpdate(); // Ejecuta la inserción.
            System.out.println("Médico agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar médico: " + e.getMessage());
        }
    }

    // Método para buscar un médico por DNI en la base de datos.
    public Medico buscarMedico(int dni) {
        String sql = "SELECT * FROM Medico WHERE DNI = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, dni); // Asigna el DNI en la consulta.
            ResultSet rs = pstmt.executeQuery(); // Ejecuta la consulta.

            // Si encuentra el médico, lo crea usando los datos del resultado.
            if (rs.next()) {
                return new Medico(
                        rs.getInt("DNI"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("especialidad_ID"),
                        rs.getString("matricula"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar médico: " + e.getMessage());
        }
        return null;
    }

    // Método para actualizar los datos de un médico existente.
    public void editarMedico(Medico medico) {
        String sql = "UPDATE Medico SET nombre = ?, apellido = ?, especialidad_ID = ?, matricula = ? WHERE DNI = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, medico.getNombre());
            pstmt.setString(2, medico.getApellido());
            pstmt.setInt(3, medico.getEspecialidadId());
            pstmt.setString(4, medico.getMatricula());
            pstmt.setInt(5, medico.getDni());
            pstmt.executeUpdate();
            System.out.println("Médico editado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al editar médico: " + e.getMessage());
        }
    }

    // Método para eliminar un médico por DNI.
    public void eliminarMedico(int dni) {
        String sql = "DELETE FROM Medico WHERE DNI = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, dni);
            pstmt.executeUpdate();
            System.out.println("Médico eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar médico: " + e.getMessage());
        }
    }

    // Método para obtener todos los turnos atendidos por un médico específico.
    public List<Turno> obtenerTurnosPorMedico(int dniMedico) {
        List<Turno> turnos = new ArrayList<>();
        String sql = "SELECT * FROM Turno WHERE medico_DNI = ? AND estado = 'atendido'";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, dniMedico);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Turno turno = new Turno(
                        rs.getInt("ID_TURNO"),
                        rs.getInt("paciente_DNI"),
                        rs.getInt("medico_DNI"),
                        rs.getInt("prioridad_ID"),
                        rs.getString("estado"),
                        rs.getTimestamp("fecha").toLocalDateTime());
                turnos.add(turno);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener turnos: " + e.getMessage());
        }
        return turnos;
    }

    // Genera un reporte diario con los turnos atendidos por un médico específico.
    public Reporte generarReporteDiario(int dniMedico) {
        List<Turno> turnosAtendidos = obtenerTurnosPorMedico(dniMedico);
        Reporte reporte = new Reporte(dniMedico);
        reporte.generar(turnosAtendidos);
        return reporte;
    }

    // Obtiene todos los pacientes registrados en la base de datos.
    public List<Paciente> obtenerPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM Paciente";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paciente paciente = new Paciente(
                        rs.getInt("DNI"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getInt("especialidad_ID"),
                        pacienteServicio.generarCodigoTurno() // Generar el código de turno con PacienteServicio
                );
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener lista de pacientes: " + e.getMessage());
        }

        return pacientes;
    }

    // Método para obtener todos los médicos registrados en la base de datos.
    public List<Medico> obtenerMedicos() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM Medico";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // Itera sobre cada registro obtenido del resultado de la consulta.
            while (rs.next()) {
                Medico medico = new Medico(
                        rs.getInt("DNI"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("especialidad_ID"),
                        rs.getString("matricula"));

                // Agrega la instancia de Medico a la lista de médicos.
                medicos.add(medico);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener lista de médicos: " + e.getMessage());
        }

        return medicos;
    }
}
