/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package modelo;

public class Producto {
    private int id;
    private String nombre;
    private double precio;

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String toString() {
        return "[" + id + "] " + nombre + " - $" + precio;
    }
}
package modelo;

public class Venta {
    private Producto producto;
    private int cantidad;

    public Venta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return producto.getPrecio() * cantidad;
    }

    public String toString() {
        return cantidad + " x " + producto.getNombre() + " = $" + getTotal();
    }
}
import java.util.Scanner;
import java.util.List;
import modelo.Producto;
import modelo.Venta;

public class VistaConsola {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Registrar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Vender producto");
        System.out.println("4. Mostrar ventas");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
        return sc.nextInt();
    }

    public Producto pedirProducto() {
        sc.nextLine();
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        return new Producto(0, nombre, precio); // el ID lo asigna el controlador
    }

    public int pedirIdProducto() {
        System.out.print("ID del producto a vender: ");
        return sc.nextInt();
    }

    public int pedirCantidad() {
        System.out.print("Cantidad: ");
        return sc.nextInt();
    }

    public void mostrarProductos(List<Producto> productos) {
        System.out.println("Productos disponibles:");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public void mostrarVentas(List<Venta> ventas) {
        double total = 0;
        System.out.println("Ventas realizadas:");
        for (Venta v : ventas) {
            System.out.println(v);
            total += v.getTotal();
        }
        System.out.println("Total vendido: $" + total);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
* 
* package controlador;

import modelo.Producto;
import modelo.Venta;
import vista.VistaConsola;

import java.util.ArrayList;
import java.util.List;

public class ControladorVentas {
    private List<Producto> productos = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();
    private VistaConsola vista;
    private int contadorId = 1;

    public ControladorVentas(VistaConsola vista) {
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 -> registrarProducto();
                case 2 -> vista.mostrarProductos(productos);
                case 3 -> venderProducto();
                case 4 -> vista.mostrarVentas(ventas);
                case 0 -> vista.mostrarMensaje("Gracias por usar el sistema.");
                default -> vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void registrarProducto() {
        Producto p = vista.pedirProducto();
        Producto conId = new Producto(contadorId++, p.getNombre(), p.getPrecio());
        productos.add(conId);
        vista.mostrarMensaje("Producto registrado con ID: " + conId.getId());
    }

    private void venderProducto() {
        vista.mostrarProductos(productos);
        int id = vista.pedirIdProducto();
        int cantidad = vista.pedirCantidad();

        for (Producto p : productos) {
            if (p.getId() == id) {
                ventas.add(new Venta(p, cantidad));
                vista.mostrarMensaje("Venta realizada.");
                return;
            }
        }
        vista.mostrarMensaje("Producto no encontrado.");
    }
}
* import controlador.ControladorVentas;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorVentas controlador = new ControladorVentas(vista);
        controlador.iniciar();
    }
}
 */
/**
 *
 * @author sebas
 */
public class vistas2 {
    
}
