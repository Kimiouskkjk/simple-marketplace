package org.gremio.testes;
import org.gremio.database.ConnectionDB;


public class Main {
    public static void main(String[] args) {
        ConnectionDB cu = new ConnectionDB();
        cu.getConnection();
        System.out.println();

    }
}