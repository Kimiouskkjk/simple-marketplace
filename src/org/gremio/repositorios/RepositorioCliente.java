package org.gremio.repositorios;

import java.sql.*;

import org.gremio.classe.Cliente;
import org.gremio.database.ConnectionDB;

public class RepositorioCliente {
    public Cliente getById(long id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome_usuario");
                    int cpf = rs.getInt("cpf");
                    String senha = rs.getString("senha_usuario");
                    String adress = rs.getString("endereco_cliente");

                    return new Cliente(nome,senha, (int) id ,adress, (int) cpf);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
