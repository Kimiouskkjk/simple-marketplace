package org.Interface.classe;

import java.util.HashMap;
import java.util.Scanner;


public class Registro {
    private static HashMap<String, Usuario> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar conta");
            System.out.println("2. Fazer login");
            System.out.println("3. Sair");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Endereço: ");
        String address = scanner.nextLine();

        System.out.println("Escolha o tipo de conta:");
        System.out.println("1. org.Interface.classe.Cliente");
        System.out.println("2. org.Interface.classe.Vendedor");
        int type = scanner.nextInt();
        scanner.nextLine();

        if (type == 1) {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            String chave = name + cpf; // Remove espaços extras
            users.put(chave, new Cliente(name, address, cpf));
        } else if (type == 2) {
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            String chave = name + cnpj; // Remove espaços extras
            users.put(chave, new Vendedor(name, address, cnpj));
        } else {
            System.out.println("Opção inválida!");
            return;
        }
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void loginUser(Scanner scanner) {
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("CPF/CNPJ: ");
        String cpf = scanner.nextLine();

        String chave = name + cpf;

        if (users.containsKey(chave)) {
            Usuario user = users.get(chave);
            System.out.println("Login bem-sucedido! Bem-vindo, " + user.name);
            if (user instanceof Cliente) {
                Cliente cliente = (Cliente) user;
                cliente.visualizarCarrinho();
                cliente.pagamento(scanner);
                cliente.rastrearPedido(scanner);
            } else if (user instanceof Vendedor) {
                Vendedor vendedor = (Vendedor) user;
                vendedor.listarProdutos();
                System.out.println("Deseja cadastrar um novo produto? (s/n)");
                String resposta2 = scanner.nextLine();
                if (resposta2.equalsIgnoreCase("s")) {
                    vendedor.cadastrarProduto(scanner);
                }
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}