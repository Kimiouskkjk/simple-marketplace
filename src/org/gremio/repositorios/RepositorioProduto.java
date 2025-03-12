package org.gremio.repositorios;
import java.sql.*;

import java.util.ArrayList.*;
import org.gremio.classe.Produto;
import org.gremio.database.ConnectionDB;
public class RepositorioProduto {
    public Produto getById(long id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome_produto");
                    double valor = rs.getInt("valor_produto");
                    String descricao = rs.getString("descricao_produto");
                    int estoque = rs.getInt("estoque_produto");
                    String vendedor = rs.getString("nome_vendedor");

                    return new Produto((int) id,nome, valor, descricao,(int) estoque, vendedor);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
