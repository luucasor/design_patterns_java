package investimento;

public class RealizadorDeInvestimentos {

    public double realiza(Conta conta, Investimento investimento){
        double resultado = investimento.calcula(conta);

        conta.deposita(resultado * 0.75);
        return conta.getSaldo();
    }
}
