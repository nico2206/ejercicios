/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudio.vista;

/**
 *
 * @author sebas
 */
import estudio.dao.EstudianteDAO;        // Usamos el DAO para registrar estudiantes
import estudio.model.Estudiante;         // Usamos la clase Estudiante
import java.util.Scanner;        // Para leer datos del usuario

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Permite leer desde teclado
        EstudianteDAO dao = new EstudianteDAO();  // Creamos el objeto que interactúa con la BD

        // Pedimos los datos al usuario
        System.out.println("=== Registro de Estudiantes ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();

        // Creamos un nuevo estudiante con los datos ingresados
        Estudiante estudiante = new Estudiante(0, nombre, carrera, edad);

        // Usamos el DAO para guardar el estudiante en la base de datos
        dao.agregarEstudiante(estudiante);

        System.out.println("✅ Estudiante registrado con éxito.");
    }
}
