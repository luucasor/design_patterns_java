package chainOfResponsibility.requisicoesweb;

public class RespostaEmPorcento implements Resposta {

    private Resposta outraResposta;

    public RespostaEmPorcento() {
        this.outraResposta = null;
    }

    public RespostaEmPorcento(Resposta outraResposta) {
        this.outraResposta = outraResposta;
    }

    @Override
    public String responde(Requisicao req, Conta conta) {
        if(req.getFormato() == Requisicao.Formato.PORCENTO){
            return conta.getTitular() + "%" + conta.getSaldo();
        } else if(outraResposta != null){
            return outraResposta.responde(req, conta);
        }
        throw new RuntimeException("Formato de resposta não encontrado");
    }
}
