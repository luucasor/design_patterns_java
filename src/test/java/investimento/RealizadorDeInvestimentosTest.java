package investimento;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RealizadorDeInvestimentosTest {

    Conta conta;
    Investimento investimento;

    @Before
    public void setUp(){
        conta = new Conta();
        conta.deposita(100);
    }

    @Test
    public void deveRealizarInvestimentoConservador(){
        investimento = new Conservador();
        assertEquals(100.6, new RealizadorDeInvestimentos().realiza(conta, investimento), 0.0001);
    }

    @Test
    public void deveRealizarInvestimentoModerado(){
        investimento = new Moderado();
        double value1 = 100.525;
        double value2 = 101.875;

        double resultado = new RealizadorDeInvestimentos().realiza(conta, investimento);
        assertTrue(resultado == value1 || resultado == value2);
    }

    @Test
    public void deveRealizarInvestimentoArrojado(){
        investimento = new Arrojado();
        double value1 = 100.45;
        double value2 = 103.75;
        double value3 = 102.25;

        double resultado = new RealizadorDeInvestimentos().realiza(conta, investimento);
        assertTrue(resultado == value1 || resultado == value2 || resultado == value3);
    }
}
