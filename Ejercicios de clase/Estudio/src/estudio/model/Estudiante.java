/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudio.model;

/**
 *
 * @author sebas
 */
public class Estudiante {
    // Atributos privados de la clase
    private int id;           // ID del estudiante (autoincremental en la base de datos)
    private String nombre;    // Nombre del estudiante
    private String carrera;   // Carrera del estudiante
    private int edad;         // Edad del estudiante

    // Constructor vacío (necesario para crear objetos sin pasar datos)
    public Estudiante() {}

    // Constructor con todos los parámetros
    public Estudiante(int id, String nombre, String carrera, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
        this.edad = edad;
    }

    // Métodos getter y setter para cada atributo
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
}