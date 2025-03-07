package org.Interface.classe;

public class Entregador {
    String transportadora = "Correios";
    Pedido pacote;
    String rastreio;
    String localizacaoAtual = "Curitiba - PR";

    Entregador(Pedido pacote) {
        this.pacote = pacote;
        this.rastreio = pacote.numero;
    }

    public void imprimirDetalhesEntrega() {
        System.out.println("Transportadora: " + transportadora);
        System.out.println("Número de rastreio: " + rastreio);
        System.out.println("Localização Atual: " + localizacaoAtual);
        pacote.imprimirDetalhes();
    }
}