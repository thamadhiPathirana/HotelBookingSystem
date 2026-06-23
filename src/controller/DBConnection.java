/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    // This will hold our single database connection instance
    private static Connection con = null;

    public static Connection getConnection() {
        try {
            // Check if we need to create a new connection
            if (con == null || con.isClosed()) {
                // 1. Load the MySQL Database Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // 2. Setup database connection credentials
                String url = "jdbc:mysql://localhost:3306/hotel_db";
                String username = "root"; 
                String password = ""; // Leave empty for default XAMPP configuration
                
                // 3. Establish the connection
                con = DriverManager.getConnection(url, username, password);
                System.out.println("Database Connected Successfully!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver Missing: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database Connection Failed: " + e.getMessage());
        }
        return con;
    }
    
}
