import java.util.Random;

public class Pedido {
    String numero;
    Produto produto;
    Cliente cliente;
    String metodoPagamento;
    double valorFinal;

    Pedido(Produto produto, Cliente cliente, String metodoPagamento, double valorFinal) {
        this.numero = gerarNumeroPedido();
        this.produto = produto;
        this.cliente = cliente;
        this.metodoPagamento = metodoPagamento;
        this.valorFinal = valorFinal;
    }

    private String gerarNumeroPedido() {
        Random random = new Random();
        int numeroPedido = 100000 + random.nextInt(900000);
        return String.valueOf(numeroPedido);
    }

    public void imprimirDetalhes() {
        System.out.println("Número do Pedido: " + numero);
        System.out.println("Cliente: " + cliente.name);
        System.out.println("Endereço: " + cliente.address);
        System.out.println("Produto: " + produto.nome);
        System.out.println("Descrição: " + produto.descricao);
        System.out.println("Forma de Pagamento: " + metodoPagamento);
    }
}
