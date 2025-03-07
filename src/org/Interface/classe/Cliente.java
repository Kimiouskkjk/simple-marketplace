package org.Interface.classe;//Import necessário para escanear respostas do usuário
import java.util.Scanner;

public class Cliente extends Usuario {
    String cpf;
    Produto carrinho = new Produto("Nintendo Switch", 1000.0, "console da nintendo", 52, "Nintendo", new String[]{"Azul"});
    Pedido ultimoPedido;

    Cliente(String name, String address, String cpf) {
        super(name, address);
        this.cpf = cpf;
    }

    public void pagamento(Scanner scanner) {
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1 = Pix");
        System.out.println("2 = Débito");
        System.out.println("3 = Crédito");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        int parcelas = 1;
        if (opcao == 3) {
            System.out.println("Digite o número de parcelas:");
            parcelas = scanner.nextInt();
            scanner.nextLine();
        }

        double valorFinal = Pagamento.calcularValorFinal(carrinho.valor, opcao, parcelas);

        String metodo = switch (opcao) {
            case 1 -> "Pix (10% de desconto!)";
            case 2 -> "Débito";
            case 3 -> "Crédito (Até 12x sem juros!)";
            default -> "Inválido";
        };

        if (!metodo.equals("Inválido")) {
            Pedido pedido = new Pedido(carrinho,this, metodo, valorFinal);
            ultimoPedido = pedido;
            System.out.println("org.Interface.classe.Pagamento realizado com sucesso via " + metodo + "!");
            System.out.println("Valor final: R$" + valorFinal);
            System.out.println("Você adquiriu: " + carrinho.nome);

            Entregador entregador = new Entregador(pedido);
        } else {
            System.out.println("Opção inválida, tente novamente.");
        }
    }
    public void rastrearPedido(Scanner scanner) {
        if (ultimoPedido != null) {
            Entregador entregador = new Entregador(ultimoPedido);
            entregador.imprimirDetalhesEntrega();
        } else {
            System.out.println("Nenhum pedido encontrado para rastreamento.");
        }
    }
    public void visualizarCarrinho() {
        if (carrinho != null) {
            System.out.println("Carrinho:");
            System.out.println("org.Interface.classe.Produto: " + carrinho.nome);
            System.out.println("Descrição: " + carrinho.descricao);
            System.out.println("Valor: R$" + carrinho.valor);
            System.out.println("Estoque disponível: " + carrinho.estoque);
            System.out.println("org.Interface.classe.Vendedor: " + carrinho.vendedor);
        } else {
            System.out.println("O carrinho está vazio.");
        }
    }
}
