/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventarioProducto;

/**
 *
 * @author mariacamilaparrasierra
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                \n--- MENÚ INVENTARIO ---
                1. Agregar producto
                2. Mostrar productos
                3. Actualizar stock
                4. Calcular valor total del inventario
                0. Salir
                """);
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    inventario.agregarProducto(new Producto(nombre, cantidad, precio));
                }
                case 2 -> inventario.mostrarProductos();
                case 3 -> {
                    System.out.print("Nombre del producto a actualizar: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nueva cantidad: ");
                    int cantidad = sc.nextInt();
                    inventario.actualizarStock(nombre, cantidad);
                }
                case 4 -> {
                    double total = inventario.calcularValorInventario();
                    System.out.printf("💰 Valor total del inventario: $%.2f%n", total);
                }
            }
        } while (opcion != 0);

        System.out.println("👋 Programa finalizado.");
    }
}

