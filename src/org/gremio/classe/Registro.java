package org.gremio.classe;

import org.gremio.database.ConnectionDB;

import java.util.Scanner;
import java.sql.*;


public class Registro {
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 - Login");
            System.out.println("2 - Registrar");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            if (escolha == 1) {
                System.out.print("Usuário: ");
                String username = scanner.nextLine();
                System.out.print("Senha: ");
                String password = scanner.nextLine();

                if (autenticarUsuario(username, password)) {
                    System.out.println("Login bem-sucedido!");
                } else {
                    System.out.println("Usuário ou senha incorretos.");
                }
            } else if (escolha == 2) {
                System.out.print("Escolha um nome de usuário: ");
                String username = scanner.nextLine();
                System.out.print("Adicione um endereço: ");
                String adress = scanner.nextLine();
                System.out.print("Escolha uma senha: ");
                String password = scanner.nextLine();

                if (registrarUsuario(username, password)) {
                    System.out.println("Usuário registrado com sucesso!");
                } else {
                    System.out.println("Erro ao registrar usuário.");
                }
            } else if (escolha == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private static boolean autenticarUsuario(String username, String password) {
        String sql = "SELECT * FROM USUARIO WHERE NOME_USUARIO = ? AND SENHA_USUARIO = ?";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, username);
            pstm.setString(2, password );
            ResultSet rs = pstm.executeQuery();

            return rs.next(); // Retorna true se encontrou o usuário

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean registrarUsuario(String username, String password) {
        String sql = "INSERT INTO usuario (NOME_USUARIO, SENHA_USUARIO) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrabalhoSQL",
                "root", "gremio");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.getMessage();
            return false;
        }
    }}