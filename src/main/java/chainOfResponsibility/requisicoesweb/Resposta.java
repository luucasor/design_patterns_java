package chainOfResponsibility.requisicoesweb;

public interface Resposta {
    String responde(Requisicao req, Conta conta);
}
