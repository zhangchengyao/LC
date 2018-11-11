import java.util.Random;

public class LC528_RandomPickWithWeight {
    private int[] wa;
    private int total;
    private Random random;
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
        int val = random.nextInt(total)+1;
        int left = 0;
        int right = wa.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(wa[mid]==val) return mid;
            else if(wa[mid]>val) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}
