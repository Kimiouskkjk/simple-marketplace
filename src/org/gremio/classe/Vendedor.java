package org.gremio.classe;

import java.util.ArrayList;
import java.util.Scanner;


public class Vendedor extends Usuario {
    int cnpj;
    ArrayList<Produto> produtos = new ArrayList<>();
    String adress;

    public Vendedor(String name, String senha, int id, int cnpj, String adress) {
        super(name, senha, id);
        this.cnpj = cnpj;
        this.adress = adress;
    }

    public void cadastrarProduto(Scanner scanner) {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Estoque: ");
        int estoque = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Variações do produto: ");
        String[] cores = scanner.nextLine().split(",");

        Produto novoProduto = new Produto(id, nome, valor, descricao, estoque, this.name);
        produtos.add(novoProduto);
        System.out.println("org.Interface.classe.Produto cadastrado com sucesso!");
    }
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Seus produtos cadastrados:");
            for (Produto produto : produtos) {
                System.out.println("- " + produto.nome + " | Preço: " + produto.valor + " | Estoque: " + produto.estoque);
            }
        }
    }
}

