import java.util.ArrayList;
import java.util.Scanner;


public class Vendedor extends Usuario {
    String cnpj;
    ArrayList<Produto> produtos = new ArrayList<>();

    Vendedor(String name, String address, String cnpj) {
        super(name, address);
        this.cnpj = cnpj;
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

        Produto novoProduto = new Produto(nome, valor, descricao, estoque, this.name, cores);
        produtos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
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


