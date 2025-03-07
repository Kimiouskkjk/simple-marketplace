package org.Interface.classe;

public class Pagamento {
    public static double calcularValorFinal(double valor, int metodo, int parcelas) {
        if (metodo == 1) { // Pix
            return valor * 0.90; // 10% de desconto
        } else if (metodo == 3 && parcelas > 12) { // Crédito parcelado acima de 12x
            int parcelasExtras = parcelas - 12;
            double taxaJuros = 1 + (parcelasExtras * 0.02);
            return valor * taxaJuros;
        }
        return valor; // Sem desconto ou juros
    }
}