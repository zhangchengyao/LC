import java.util.HashMap;
import java.util.Map;

public class LC873_LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] A) {
        int[][] dp = new int[A.length][A.length];
        Map<Integer, Integer> idxMap = new HashMap<>();
        for(int i = 0; i < A.length; i++) idxMap.put(A[i], i);

        int longest = 0;
        for(int i = 2; i < A.length; i++) {
            for(int j = i - 1; j > 0; j--) {
                int diff = A[i] - A[j];
                if(diff >= A[j]) break;

                if(idxMap.containsKey(diff)) {
                    dp[j][i] = Math.max(dp[idxMap.get(diff)][j], 2) + 1;
                    longest = Math.max(longest, dp[j][i]);
                }
            }
        }

        return longest >= 3 ? longest : 0;
    }
}
