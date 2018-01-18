package strategy.impostos;

public interface Imposto {

    double valor = 0;
    double calcula(Orcamento orcamento);
}
