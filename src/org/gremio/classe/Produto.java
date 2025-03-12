package org.gremio.classe;

public class Produto {
    int id;
    String nome;
    double valor;
    String descricao;
    int estoque;
    String vendedor;

    public Produto(int id, String nome, double valor, String descricao, int estoque, String vendedor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.estoque = estoque;
        this.vendedor = vendedor;
    }
}
