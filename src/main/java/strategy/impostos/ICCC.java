package strategy.impostos;

public class ICCC implements Imposto {

    @Override
    public double calcula(Orcamento orcamento) {
        double valorOrcamento = orcamento.getValor();
        if(valorOrcamento < 1000){
            return valorOrcamento * 0.05;
        } else if (valorOrcamento >= 1000 && valorOrcamento <=3000){
            return valorOrcamento * 0.07;
        } else if (valorOrcamento > 3000){
            return (valorOrcamento * 0.08) + 30;
        }
        return 0;
    }
}
