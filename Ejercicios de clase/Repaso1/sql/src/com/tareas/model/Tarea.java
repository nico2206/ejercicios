package com.tareas.model;

public class Tarea {
    private int id;
    private String descripcion;
    private boolean completada;

    public Tarea(int id, String descripcion, boolean completada) {
        this.id = id;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public boolean isCompletada() { return completada; }

    public void setCompletada(boolean completada) { this.completada = completada; }
}
