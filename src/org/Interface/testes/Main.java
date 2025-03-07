package org.Interface.testes;
import org.Interface.database.ConnectionDB;


public class Main {
    public static void main(String[] args) {
        ConnectionDB cu = new ConnectionDB();
        cu.getConnection();
        System.out.println();

    }
}