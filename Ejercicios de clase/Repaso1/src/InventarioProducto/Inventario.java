/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventarioProducto;

/**
 *
 * @author mariacamilaparrasierra
 */
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("📦 No hay productos en el inventario.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    public void actualizarStock(String nombre, int nuevaCantidad) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setCantidad(nuevaCantidad);
                System.out.println("✅ Stock actualizado.");
                return;
            }
        }
        System.out.println("❌ Producto no encontrado.");
    }

    public double calcularValorInventario() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getValorTotal();
        }
        return total;
    }
}
