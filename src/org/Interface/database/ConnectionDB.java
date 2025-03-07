package org.Interface.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public void getConnection() {
        Connection  connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrabalhoSQL",
                    "root", "12345678");
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}




