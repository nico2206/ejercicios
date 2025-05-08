/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

/**
 *
 * @author mariacamilaparrasierra
 */
import java.io.*;
import java.util.*;

public class Agenda {
    private List<Contacto> contactos = new ArrayList<>();
    private final String archivo = "contactos.csv";

    public Agenda() {
        cargarDesdeArchivo();
    }

    public void agregar(Contacto c) {
        contactos.add(c);
        guardarEnArchivo();
    }

    public void listar() {
        if (contactos.isEmpty()) {
            System.out.println("Agenda vacía.");
        } else {
            contactos.forEach(System.out::println);
        }
    }

    public Contacto buscar(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public void editar(String nombre) {
        Contacto c = buscar(nombre);
        if (c != null) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nuevo teléfono: ");
            c.setTelefono(sc.nextLine());
            System.out.print("Nuevo email: ");
            c.setEmail(sc.nextLine());
            guardarEnArchivo();
            System.out.println("✅ Contacto actualizado.");
        } else {
            System.out.println("❌ Contacto no encontrado.");
        }
    }

    public void eliminar(String nombre) {
        Contacto c = buscar(nombre);
        if (c != null) {
            contactos.remove(c);
            guardarEnArchivo();
            System.out.println("✅ Contacto eliminado.");
        } else {
            System.out.println("❌ Contacto no encontrado.");
        }
    }

    private void guardarEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (Contacto c : contactos) {
                writer.println(c.toCSV());
            }
        } catch (IOException e) {
            System.err.println("❌ Error al guardar archivo.");
        }
    }

    private void cargarDesdeArchivo() {
        File f = new File(archivo);
        if (!f.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    contactos.add(new Contacto(partes[0], partes[1], partes[2]));
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Error al cargar archivo.");
        }
    }
}

