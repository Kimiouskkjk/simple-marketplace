package org.gremio.classe;//Import necessário para escanear respostas do usuário
import java.util.Scanner;

public class Cliente extends Usuario {
    int cpf;
    Pedido ultimoPedido;
    String carrinho;
    String adress;

    public Cliente(String name, String senha, int id ,String adress, int cpf) {
        super(name, senha, id);
        this.adress = adress;
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

        String metodo = switch (opcao) {
            case 1 -> "Pix (10% de desconto!)";
            case 2 -> "Débito";
            case 3 -> "Crédito (Até 12x sem juros!)";
            default -> "Inválido";
        };

        if (!metodo.equals("Inválido")) {
            System.out.println("org.Interface.classe.Pagamento realizado com sucesso via " + metodo + "!");
        } else {
            System.out.println("Opção inválida, tente novamente.");
        }
    }
    public void visualizarCarrinho() {
        if (carrinho != null) {
            System.out.println("Carrinho:");
        } else {
            System.out.println("O carrinho está vazio.");
        }
    }
}
