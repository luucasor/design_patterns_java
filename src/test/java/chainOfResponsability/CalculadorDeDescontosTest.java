package chainOfResponsability;

import chainOfResponsibility.descontos.CalculadorDeDescontos;
import chainOfResponsibility.descontos.Item;
import chainOfResponsibility.descontos.Orcamento;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculadorDeDescontosTest {

    CalculadorDeDescontos calculador;
    Orcamento orcamento;

    @Before
    public void setUp(){
        calculador = new CalculadorDeDescontos();
    }

    @Test
    public void naoDeveAplicarNenhumDesconto() {
        orcamento = new Orcamento(500.0);
        orcamento.adicionaItem(new Item("CANETA", 250.0));
        orcamento.adicionaItem(new Item("LAPIS", 250.0));

        double desconto = calculador.calcula(orcamento);
        assertTrue(desconto == 0);
    }

    @Test
    public void deveAplicarDezPorCentoDeDesconto(){
        orcamento = new Orcamento(500.0);
        orcamento.adicionaItem(new Item("CERVEJA CLARA", 200.0));
        orcamento.adicionaItem(new Item("CERVEJA ESCURA", 250.0));
        orcamento.adicionaItem(new Item("CERVEJA VERMELHA", 180.0));
        orcamento.adicionaItem(new Item("CERVEJA AMARGA", 220.0));
        orcamento.adicionaItem(new Item("CERVEJA IMPORTADA", 300.0));

        double desconto = calculador.calcula(orcamento);
        assertEquals(0.1, desconto, 0.1);
    }

    @Test
    public void deveAplicarSetePorCentoDeDesconto(){
        orcamento = new Orcamento(600.0);
        orcamento.adicionaItem(new Item("BANHEIRA 1000L", 600.0));

        double desconto = calculador.calcula(orcamento);
        assertEquals(42, desconto, 0.1);
    }
}
