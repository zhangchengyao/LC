import java.util.ArrayList;
import java.util.List;

public class LC656_CoinPath {
    private List<Integer> best = null;

    public List<Integer> cheapestJump(int[] A, int B) {
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for(int i = 1; i < dp.length; i++) {
            if(A[i] == -1) continue;
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= B; j++) {
                if(i - j < 0) break;
                if(A[i - j] == -1) continue;
                dp[i] = Math.min(dp[i], dp[i - j] + A[i]);
            }
        }

        backtrack(A.length - 1, dp, A, B, new ArrayList<>());

        return best == null ? new ArrayList<>() : best;
    }

    private void backtrack(int cur, int[] dp, int[] A, int B, List<Integer> path) {
        if(cur < 0) return;
        if(cur == 0) {
            path.add(0, 1);
            if(best == null || smaller(path, best)) best = new ArrayList<>(path);
            path.remove(0);
            return;
        }
        for(int i = 1; i <= B; i++) {
            if(cur - i >= 0 && dp[cur - i] + A[cur] == dp[cur]) {
                path.add(0, cur + 1);
                backtrack(cur - i, dp, A, B, path);
                path.remove(0);
            }
        }
    }

    private boolean smaller(List<Integer> path, List<Integer> best) {
        for(int i = 0; i < Math.min(path.size(), best.size()); i++) {
            if(path.get(i) < best.get(i)) return true;
            else if(path.get(i) > best.get(i)) return false;
        }

        return path.size() < best.size();
    }
}
