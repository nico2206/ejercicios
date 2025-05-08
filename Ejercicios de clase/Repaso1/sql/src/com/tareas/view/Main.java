package com.tareas.view;
import com.tareas.controller.TareaDAO;
import com.tareas.model.Tarea;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TareaDAO dao = new TareaDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n-- GESTOR DE TAREAS CON BD --");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Ver tareas pendientes");
            System.out.println("3. Ver tareas completadas");
            System.out.println("4. Marcar como completada");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Descripción: ");
                    dao.agregarTarea(sc.nextLine());
                }
                case 2 -> dao.obtenerTareas(false).forEach(System.out::println);
                case 3 -> dao.obtenerTareas(true).forEach(System.out::println);
                case 4 -> {
                    System.out.print("ID tarea a completar: ");
                    dao.marcarComoCompletada(sc.nextInt()); sc.nextLine();
                }
            }
        } while (opcion != 0);
    }
}
