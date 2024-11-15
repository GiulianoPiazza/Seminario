// La clase `DatabaseConnection` proporciona una conexión a la base de datos MySQL.
// Define la URL de conexión, el usuario y la contraseña.

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // URL de la base de datos, incluyendo la dirección del servidor, el puerto y el nombre de la base de datos.
    private static final String URL = "jdbc:mysql://localhost:3306/bd_clinicaCBA";

    // Usuario de la base de datos.
    private static final String USER = "root";

    // Contraseña de la base de datos.
    private static final String PASSWORD = "g1234567P";

    // Método que establece y retorna una conexión a la base de datos.
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
