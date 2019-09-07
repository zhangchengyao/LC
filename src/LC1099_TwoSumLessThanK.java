import java.util.TreeSet;

public class LC1099_TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        TreeSet<Integer> tset = new TreeSet<>();
        int S = -1;
        for(int x: A) {
            Integer y = tset.lower(K - x);
            if(y != null) {
                S = Math.max(S, x + y);
            }
            tset.add(x);
        }

        return S;
    }
}
