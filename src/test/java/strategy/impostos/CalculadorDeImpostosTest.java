package strategy.impostos;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadorDeImpostosTest {

    Orcamento orcamento;

    @Test
    public void deveRetornarValorOrcamentoVezesCincoPorCento(){
        double menorQueMil = 999;
        orcamento = new Orcamento(menorQueMil);
        double resultado = new CalculadorDeImpostos(orcamento, new ICCC()).calcula();
        assertEquals(49.95, resultado, 0.01);
    }

    @Test
    public void deveRetornarValorOrcamentoVezesSetePorCento(){
        double entreMilETresMil = 1500;
        orcamento = new Orcamento(entreMilETresMil);
        double resultado = new CalculadorDeImpostos(orcamento, new ICCC()).calcula();
        assertEquals(105.0, resultado,  0.01);
    }

    @Test
    public void deveRetornarValorOrcamentoVezesOitoPorCentoMaisTrinta(){
        double maiorQueTresMil = 3001;
        orcamento = new Orcamento(maiorQueTresMil);
        double resultado = new CalculadorDeImpostos(orcamento, new ICCC()).calcula();
        assertEquals(270.08, resultado, 0.01);
    }
}