package com.healthcareApp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    private static final String URL = "jdbc:mysql://localhost:3306/healthcaredata";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Connection established: " + connection);
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println(" JDBC Driver not found: " + e.getMessage());
            throw new SQLException("JDBC Driver not found", e);
        } catch (SQLException e) {
            System.err.println(" Failed to connect to DB: " + e.getMessage());
            throw e;
        }
    }
}
