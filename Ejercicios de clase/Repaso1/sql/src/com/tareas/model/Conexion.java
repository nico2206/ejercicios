package com.tareas.model;
import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/tareasdb";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
