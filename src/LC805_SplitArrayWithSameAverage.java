import java.util.HashSet;
import java.util.Set;

public class LC805_SplitArrayWithSameAverage {
    // NP problem...
    public boolean splitArraySameAverage(int[] A) {
        int total = 0;
        int n = A.length;
        for (int aA : A) total += aA;

        boolean possible = false;

        for(int k = 1; k <= n / 2; k++){
            if((total * k) % n == 0){
                possible = true;
                break;
            }
        }
        if(!possible) return false;

        Set<Integer>[][] dp = new HashSet[n + 1][n / 2 + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = new HashSet<>();
            dp[i][0].add(0);
        }
        for(int k = 1; k <= n / 2; k++){
            for(int i = 1; i <= n; i++){
                if(i < k) continue;
                dp[i][k] = new HashSet<>();
                if(dp[i - 1][k] != null){
                    for(int num: dp[i - 1][k]) dp[i][k].add(num);
                }
                if(dp[i - 1][k - 1] != null){
                    for(int num: dp[i - 1][k - 1]) dp[i][k].add(num + A[i - 1]);
                }
            }
        }

        for(int k = 1; k <= n / 2; k++){
            if((total * k) % n == 0 && dp[n][k].contains((total * k) / n)) return true;
        }

        return false;
    }
}
