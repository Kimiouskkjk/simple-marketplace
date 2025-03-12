package org.gremio.repositorios;
import java.sql.*;

import org.gremio.classe.Vendedor;
import org.gremio.database.ConnectionDB;

public class RepositorioVendedor {
    public Vendedor getById(long id) {
        String sql = "SELECT * FROM vendedor WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome_usuario");
                    int cnpj = rs.getInt("cnpj");
                    String senha = rs.getString("senha_usuario");
                    String adress = rs.getString("endereco_vendedor");

                    return new Vendedor(nome,senha, (int) id ,(int) cnpj, adress);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar vendedor com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
