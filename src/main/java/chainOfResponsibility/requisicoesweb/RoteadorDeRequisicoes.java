package chainOfResponsibility.requisicoesweb;

public class RoteadorDeRequisicoes {

    public String realizaRoteamento(Requisicao req, Conta conta){
        return new RespostaEmXml(new RespostaEmCsv(new RespostaEmPorcento())).responde(req, conta);
    }
}
