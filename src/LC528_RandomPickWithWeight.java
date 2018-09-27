import java.util.Random;

public class LC528_RandomPickWithWeight {
    int[] wa;
    int total;
    Random random;
    public LC528_RandomPickWithWeight(int[] w) {
        wa = new int[w.length];
        total = 0;
        for(int i=0;i<w.length;i++){
            total += w[i];
            if(i==0) wa[i] = w[i];
            else wa[i] = wa[i-1]+w[i];
        }
        random = new Random();
    }

    public int pickIndex() {
        int res = 0;
        int val = random.nextInt(total);
        for(int i=0;i<wa.length;i++){
            if(val<wa[i]){
                res = i;
                break;
            }
        }
        return res;
    }
}
