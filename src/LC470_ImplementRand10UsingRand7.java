import java.util.Random;

public class LC470_ImplementRand10UsingRand7 {
    public int rand10() {
        int rand = 100;
        while(rand>=40){
            rand = 7 * (rand7()-1) + rand7()-1;
        }
        return (rand % 10)+1;
    }

    private int rand7(){return new Random().nextInt(7)+1;}
}
