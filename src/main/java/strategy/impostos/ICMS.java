package strategy.impostos;

public class ICMS implements Imposto {

    @Override
    public double calcula(Orcamento orcamento) {
        return (orcamento.getValor() * 0.5) + 50.0;
    }
}
