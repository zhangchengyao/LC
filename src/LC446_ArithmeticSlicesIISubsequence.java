import java.util.HashMap;

public class LC446_ArithmeticSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] A) {
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        int res = 0;
        for(int i=0;i<A.length;i++){
            dp[i] = new HashMap<>();
            for(int j=0;j<i;j++){
                long diff = (long)A[i]-(long)A[j];
                if(diff<Integer.MIN_VALUE || diff>Integer.MAX_VALUE) continue;
                int ci = dp[i].getOrDefault((int)diff, 0);
                int cj = dp[j].getOrDefault((int)diff, 0);
                dp[i].put((int)diff, ci+cj+1);
                res += cj;
            }
        }
        return res;
    }
}
