package chainOfResponsibility.requisicoesweb;

public class RespostaEmCsv implements Resposta {

    private Resposta outraResposta;

    public RespostaEmCsv() {
        this.outraResposta = null;
    }

    public RespostaEmCsv(Resposta outraResposta) {
        this.outraResposta = outraResposta;
    }

    @Override
    public String responde(Requisicao req, Conta conta) {
        if(req.getFormato() == Requisicao.Formato.CSV){
            return conta.getTitular() + "," + conta.getSaldo();
        } else if(outraResposta != null){
            return outraResposta.responde(req, conta);
        }
        throw new RuntimeException("Formato de resposta não encontrado");
    }
}
