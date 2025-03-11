package org.gremio.classe;

public class Produto {
    String nome;
    double valor;
    String descricao;
    int estoque;
    String vendedor;
    String[] variaveis;

    Produto(String nome, double valor, String descricao, int estoque, String vendedor, String[] variaveis) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.estoque = estoque;
        this.vendedor = vendedor;
        this.variaveis = variaveis;
    }
}
