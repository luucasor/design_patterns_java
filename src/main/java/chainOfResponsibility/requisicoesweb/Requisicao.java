package chainOfResponsibility.requisicoesweb;

public class Requisicao {

    private Formato formato;

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Requisicao(Formato formato){
        this.formato = formato;
    }

    public enum Formato {
        XML,
        CSV,
        PORCENTO;
    }

    public Formato getFormato() {
        return formato;
    }
}
