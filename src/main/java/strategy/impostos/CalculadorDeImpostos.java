package strategy.impostos;

public class CalculadorDeImpostos {

    Orcamento orcamento;
    Imposto estrategiaDeImposto;

    public CalculadorDeImpostos(Orcamento orcamento, Imposto estrategiaDeImposto) {
        this.orcamento = orcamento;
        this.estrategiaDeImposto = estrategiaDeImposto;
    }

    public double calcula(){
        double resultado = estrategiaDeImposto.calcula(orcamento);
        System.out.println(resultado);
        return resultado;
    }
}
