package strategy.investimento;

import java.util.Random;

public class Arrojado implements Investimento {

    Random random;

    public Arrojado(){
        random = new Random();
    }

    @Override
    public double calcula(Conta conta) {
        int chute = random.nextInt(10);
        if(chute >= 0 && chute <= 1){
            return conta.getSaldo() * 0.05;
        } else if(chute >= 2 && chute <= 4){
            return conta.getSaldo() * 0.03;
        }
        return conta.getSaldo() * 0.006;
    }
}
