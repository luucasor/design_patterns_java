package chainOfResponsibility.descontos;

public class DescontoVendaCasada implements Desconto {

    private Desconto proximo;

    @Override
    public double desconta(Orcamento orcamento) {
        boolean possuiLapis = existe("LAPIS", orcamento);
        boolean possuiCaneta = existe("CANETA", orcamento);

        if(possuiLapis && possuiCaneta){
            return orcamento.getValor() * 0.05;
        }
        return proximo.desconta(orcamento);
    }

    @Override
    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }

    private boolean existe(String nomeItem, Orcamento orcamento) {
        for (Item item : orcamento.getItens()) {
            if(item.getNome().equals(nomeItem)){
                return true;
            }
        }
        return false;
    }
}
