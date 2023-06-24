
import java.util.Random;

public class Dados {

    public int dado1;

    public int dado2;

    public Dados(){
        Random rand = new Random();
        dado1 = rand.nextInt(6)+1;
        dado2 = rand.nextInt(6)+1;
    }
}
