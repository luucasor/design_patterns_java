package chainOfResponsibility.requisicoesweb;

public class RespostaEmXml implements Resposta {

    private Resposta outraResposta;

    public RespostaEmXml() {
        this.outraResposta = null;
    }

    public RespostaEmXml(Resposta outraResposta) {
        this.outraResposta = outraResposta;
    }

    @Override
    public String responde(Requisicao req, Conta conta) {
        if(req.getFormato() == Requisicao.Formato.XML){
            return "<conta><titular>" + conta.getTitular() + "</titular><saldo>" + conta.getSaldo() + "</saldo></conta>";
        } else if(outraResposta != null){
            return outraResposta.responde(req, conta);
        }
        throw new RuntimeException("Formato de resposta não encontrado");
    }
}
