// Archivo: Estudiante.java
import java.io.*;
import java.util.*;

class Estudiante implements Serializable {
    private String nombre;
    private int edad;
    private String carrera;

    public Estudiante(String nombre, int edad, String carrera) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCarrera() { return carrera; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Carrera: " + carrera;
    }
}

public class Main {
    private static final String FILE_NAME = "estudiantes.dat";

    public static void main(String[] args) {
        List<Estudiante> estudiantes = cargarEstudiantes();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión de Estudiantes ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Carrera: ");
                    String carrera = scanner.nextLine();
                    estudiantes.add(new Estudiante(nombre, edad, carrera));
                    guardarEstudiantes(estudiantes);
                    break;
                case 2:
                    estudiantes.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Ingrese nombre a buscar: ");
                    String buscar = scanner.nextLine();
                    estudiantes.stream()
                            .filter(e -> e.getNombre().equalsIgnoreCase(buscar))
                            .forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion inválida.");
            }
        } while (opcion != 4);
    }

    private static void guardarEstudiantes(List<Estudiante> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.err.println("Error guardando: " + e.getMessage());
        }
    }

    private static List<Estudiante> cargarEstudiantes() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Estudiante>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error cargando: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
