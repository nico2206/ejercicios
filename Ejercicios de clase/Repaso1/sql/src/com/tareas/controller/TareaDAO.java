package com.tareas.controller;
import com.tareas.model.Conexion;
import com.tareas.model.Tarea;
import java.sql.*;
import java.util.*;

public class TareaDAO {

    public void agregarTarea(String descripcion) {
        String sql = "INSERT INTO tareas (descripcion, completada) VALUES (?, false)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descripcion);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tarea> obtenerTareas(boolean completadas) {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT * FROM tareas WHERE completada = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, completadas);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Tarea(rs.getInt("id"), rs.getString("descripcion"), rs.getBoolean("completada")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void marcarComoCompletada(int id) {
        String sql = "UPDATE tareas SET completada = true WHERE id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
