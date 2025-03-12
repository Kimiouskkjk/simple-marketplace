package org.gremio.repositorios;

import java.sql.*;

import org.gremio.classe.Usuario;
import org.gremio.database.ConnectionDB;

public class RepositorioUsuario {
    public Usuario getById(long id_usuario) {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id_usuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome_usuario");
                    String senha = rs.getString("senha_usuario");

                    return new Usuario(nome, senha, (int) id_usuario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id_usuario);
            e.printStackTrace();
        }
        return null;
    }
}

