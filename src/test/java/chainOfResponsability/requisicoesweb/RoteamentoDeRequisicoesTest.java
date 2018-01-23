package chainOfResponsability.requisicoesweb;

import chainOfResponsibility.requisicoesweb.Conta;
import chainOfResponsibility.requisicoesweb.Requisicao;
import chainOfResponsibility.requisicoesweb.RoteadorDeRequisicoes;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoteamentoDeRequisicoesTest {

    Conta conta;
    Requisicao requisicao;
    RoteadorDeRequisicoes roteador;

    @Before
    public void setUp(){
        this.conta = new Conta("Lucas Ortigara Reis", 5000.00);
        this.roteador = new RoteadorDeRequisicoes();
    }

    @Test
    public void deveResponderComXML(){
        requisicao = new Requisicao(Requisicao.Formato.XML);
        String retorno = roteador.realizaRoteamento(requisicao, conta);
        assertEquals("<conta><titular>Lucas Ortigara Reis</titular><saldo>5000.0</saldo></conta>", retorno);
    }

    @Test
    public void deveResponderComCsv(){
        requisicao = new Requisicao(Requisicao.Formato.CSV);
        String retorno = roteador.realizaRoteamento(requisicao, conta);
        assertEquals("Lucas Ortigara Reis,5000.0", retorno);
    }

    @Test
    public void deveResponderComPorcento(){
        requisicao = new Requisicao(Requisicao.Formato.PORCENTO);
        String retorno = roteador.realizaRoteamento(requisicao, conta);
        assertEquals("Lucas Ortigara Reis%5000.0", retorno);
    }

    @Test(expected = RuntimeException.class)
    public void deveResponderComException(){
        requisicao = new Requisicao(null);
        roteador.realizaRoteamento(requisicao, conta);
    }
}
