package org.gremio.classe;

public class Entregador {
    int id;
    String transportadora = "Correios";
    Pedido pacote;
    int rastreio;
    String localizacaoAtual = "Curitiba - PR";

    Entregador(Pedido pacote, int id) {
        this.pacote = pacote;
        this.rastreio = pacote.id;
        this.id = id;
    }

    public void imprimirDetalhesEntrega() {
        System.out.println("Transportadora: " + transportadora);
        System.out.println("Número de rastreio: " + rastreio);
        System.out.println("Localização Atual: " + localizacaoAtual);
        pacote.imprimirDetalhes();
    }
}