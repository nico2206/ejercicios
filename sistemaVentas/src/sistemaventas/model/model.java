/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
* @author sebas
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void reducirStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
        }
    }

    public boolean tieneStock(int cantidad) {
        return cantidad <= stock;
    }

    public String toString() {
        return "[" + id + "] " + nombre + " - $" + precio + " (Stock: " + stock + ")";
    }
}
* package modelo;

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
* package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Producto;
import modelo.Venta;

public class VistaConsola {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ SUPERMERCADO ---");
        System.out.println("1. Registrar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Realizar venta");
        System.out.println("4. Ver ventas");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        return sc.nextInt();
    }

    public Producto pedirProducto(int id) {
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Stock: ");
        int stock = sc.nextInt();
        return new Producto(id, nombre, precio, stock);
    }

    public void mostrarProductos(List<Producto> productos) {
        System.out.println("\nProductos disponibles:");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public int pedirIdProducto() {
        System.out.print("ID del producto: ");
        return sc.nextInt();
    }

    public int pedirCantidad() {
        System.out.print("Cantidad a vender: ");
        return sc.nextInt();
    }

    public void mostrarVentas(List<Venta> ventas) {
        double total = 0;
        System.out.println("\nHistorial de ventas:");
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
* package controlador;

import modelo.Producto;
import modelo.Venta;
import vista.VistaConsola;

import java.util.ArrayList;
import java.util.List;

public class ControladorSupermercado {
    private List<Producto> productos = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();
    private VistaConsola vista;
    private int idProducto = 1;

    public ControladorSupermercado(VistaConsola vista) {
        this.vista = vista;
    }

    public void iniciar() {
        int op;
        do {
            op = vista.mostrarMenu();
            switch (op) {
                case 1 -> registrarProducto();
                case 2 -> vista.mostrarProductos(productos);
                case 3 -> realizarVenta();
                case 4 -> vista.mostrarVentas(ventas);
                case 0 -> vista.mostrarMensaje("Gracias por usar el sistema.");
                default -> vista.mostrarMensaje("Opción inválida.");
            }
        } while (op != 0);
    }

    private void registrarProducto() {
        Producto nuevo = vista.pedirProducto(idProducto++);
        productos.add(nuevo);
        vista.mostrarMensaje("Producto registrado correctamente.");
    }

    private void realizarVenta() {
        vista.mostrarProductos(productos);
        int id = vista.pedirIdProducto();
        int cantidad = vista.pedirCantidad();

        for (Producto p : productos) {
            if (p.getId() == id) {
                if (p.tieneStock(cantidad)) {
                    p.reducirStock(cantidad);
                    ventas.add(new Venta(p, cantidad));
                    vista.mostrarMensaje("Venta realizada.");
                } else {
                    vista.mostrarMensaje("Stock insuficiente.");
                }
                return;
            }
        }
        vista.mostrarMensaje("Producto no encontrado.");
    }
}
* import controlador.ControladorSupermercado;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorSupermercado controlador = new ControladorSupermercado(vista);
        controlador.iniciar();
    }
}
*/

package sistemaventas.model;

/**
 *
 * @author sebas
 */
public class model {
    
}
