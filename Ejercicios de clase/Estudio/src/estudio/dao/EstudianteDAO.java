/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudio.dao;

/**
 *
 * @author sebas
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import estudio.model.Estudiante;           // Importamos la clase Estudiante del paquete 'model'
import estudio.conexion.Conexion;       // Importamos la clase que da la conexión a MySQL

public class EstudianteDAO {

    // Método para insertar un estudiante en la base de datos
    public void agregarEstudiante(Estudiante estudiante) {
        // Consulta SQL con placeholders para seguridad
        String sql = "INSERT INTO escuela (nombre, carrera, edad) VALUES (?, ?, ?)";

        try {
            // Obtenemos la conexión a la base de datos
            Connection conexion = Conexion.getConexion();

            // Preparamos la consulta para evitar inyección SQL
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Rellenamos los ? con los datos del estudiante
            statement.setString(1, estudiante.getNombre());
            statement.setString(2, estudiante.getCarrera());
            statement.setInt(3, estudiante.getEdad());

            // Ejecutamos la consulta de inserción
            statement.executeUpdate();

            // Cerramos los recursos
            statement.close();
            conexion.close();

        } catch (SQLException e) {
            // Si hay error al insertar, lo mostramos
            System.out.println("Error al agregar estudiante: " + e.getMessage());
        }
    }
}
