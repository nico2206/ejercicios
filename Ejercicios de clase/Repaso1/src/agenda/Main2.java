/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

/**
 *
 * @author mariacamilaparrasierra
 */
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                \n--- AGENDA DE CONTACTOS ---
                1. Agregar contacto
                2. Listar contactos
                3. Buscar contacto
                4. Editar contacto
                5. Eliminar contacto
                0. Salir
                """);
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    agenda.agregar(new Contacto(nombre, tel, email));
                }
                case 2 -> agenda.listar();
                case 3 -> {
                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine();
                    Contacto c = agenda.buscar(buscar);
                    System.out.println(c != null ? c : "❌ No encontrado.");
                }
                case 4 -> {
                    System.out.print("Nombre a editar: ");
                    agenda.editar(sc.nextLine());
                }
                case 5 -> {
                    System.out.print("Nombre a eliminar: ");
                    agenda.eliminar(sc.nextLine());
                }
            }
        } while (opcion != 0);

        System.out.println("👋 Programa finalizado.");
    }
}

