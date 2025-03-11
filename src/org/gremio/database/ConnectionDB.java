package org.gremio.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public Connection getConnection() {
        Connection  connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrabalhoSQL",
                    "root", "gremio");
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return connection;
    }
}




