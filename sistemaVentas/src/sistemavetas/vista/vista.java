/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
*public class Habitacion {
    private int numero;
    private String tipo; // Ej: simple, doble
    private boolean disponible = true;

    public Habitacion(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void ocupar() {
        disponible = false;
    }

    public String toString() {
        return "Habitación " + numero + " (" + tipo + ") - " + (disponible ? "Disponible" : "Ocupada");
    }
}
* package modelo;

public class Cliente {
    private String nombre;
    private String documento;

    public Cliente(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String toString() {
        return nombre + " (DNI: " + documento + ")";
    }
}
* package modelo;

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;

    public Reserva(Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public String toString() {
        return "Reserva: " + cliente + " → " + habitacion;
    }
}
* package vista;

import java.util.List;
import java.util.Scanner;
import modelo.*;

public class VistaConsola {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- SISTEMA DE RESERVAS ---");
        System.out.println("1. Registrar habitación");
        System.out.println("2. Registrar cliente");
        System.out.println("3. Hacer reserva");
        System.out.println("4. Ver reservas");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        return sc.nextInt();
    }

    public Habitacion pedirHabitacion() {
        System.out.print("Número de habitación: ");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.print("Tipo de habitación (simple/doble): ");
        String tipo = sc.nextLine();
        return new Habitacion(num, tipo);
    }

    public Cliente pedirCliente() {
        sc.nextLine();
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Documento (DNI): ");
        String doc = sc.nextLine();
        return new Cliente(nombre, doc);
    }

    public void mostrarHabitaciones(List<Habitacion> lista) {
        System.out.println("\nHabitaciones:");
        for (Habitacion h : lista) {
            System.out.println(h);
        }
    }

    public void mostrarReservas(List<Reserva> lista) {
        System.out.println("\nReservas actuales:");
        for (Reserva r : lista) {
            System.out.println(r);
        }
    }

    public int pedirNumeroHabitacion() {
        System.out.print("Ingrese el número de habitación a reservar: ");
        return sc.nextInt();
    }

    public String pedirDocumentoCliente() {
        sc.nextLine();
        System.out.print("Ingrese DNI del cliente: ");
        return sc.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
* 
* package controlador;

import modelo.*;
import vista.VistaConsola;

import java.util.ArrayList;
import java.util.List;

public class ControladorHotel {
    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private VistaConsola vista;

    public ControladorHotel(VistaConsola vista) {
        this.vista = vista;
    }

    public void iniciar() {
        int op;
        do {
            op = vista.mostrarMenu();
            switch (op) {
                case 1 -> registrarHabitacion();
                case 2 -> registrarCliente();
                case 3 -> hacerReserva();
                case 4 -> vista.mostrarReservas(reservas);
                case 0 -> vista.mostrarMensaje("Hasta pronto.");
                default -> vista.mostrarMensaje("Opción inválida.");
            }
        } while (op != 0);
    }

    private void registrarHabitacion() {
        Habitacion h = vista.pedirHabitacion();
        habitaciones.add(h);
        vista.mostrarMensaje("Habitación registrada.");
    }

    private void registrarCliente() {
        Cliente c = vista.pedirCliente();
        clientes.add(c);
        vista.mostrarMensaje("Cliente registrado.");
    }

    private void hacerReserva() {
        vista.mostrarHabitaciones(habitaciones);
        int num = vista.pedirNumeroHabitacion();
        Habitacion seleccionada = null;

        for (Habitacion h : habitaciones) {
            if (h.getNumero() == num && h.isDisponible()) {
                seleccionada = h;
                break;
            }
        }

        if (seleccionada == null) {
            vista.mostrarMensaje("Habitación no disponible.");
            return;
        }

        String dni = vista.pedirDocumentoCliente();
        Cliente cliente = null;

        for (Cliente c : clientes) {
            if (c.getDocumento().equals(dni)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            vista.mostrarMensaje("Cliente no encontrado.");
            return;
        }

        seleccionada.ocupar();
        reservas.add(new Reserva(cliente, seleccionada));
        vista.mostrarMensaje("Reserva realizada correctamente.");
    }
}
* import controlador.ControladorHotel;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorHotel controlador = new ControladorHotel(vista);
        controlador.iniciar();
    }
}
 * /

*public class vista {
package sistemavetas.vista;

/**
 *
 * @author sebas
 */
public class vista {
    
}
