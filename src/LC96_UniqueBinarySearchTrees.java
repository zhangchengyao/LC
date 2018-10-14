import java.util.HashMap;

public class LC96_UniqueBinarySearchTrees {
    // dynamic programming
    public int numTrees(int n) {
        if(n<1) return 0;
        int[][] dp = new int[n+2][n+2];
        for(int i=1;i<dp.length;i++){
            dp[i][i-1] = 1;
            dp[i][i] = 1;
        }
        for(int len=1;len<n;len++){
            for(int i=1;i<=n-len;i++){
                for(int j=i;j<=i+len;j++){
                    dp[i][i+len] += dp[i][j-1]*dp[j+1][i+len];
                }
            }
        }
        return dp[1][n];
    }
//    HashMap<String, Integer> map = new HashMap<>();
//    public int numTrees(int n) {
//        if(n<1) return 0;
//        return calculate(1, n);
//    }
//    private int calculate(int l, int r){
//        if(l>r) return 1;
//        String str = l+" "+r;
//        if(map.containsKey(str)) return map.get(str);
//        int res = 0;
//        for(int i=l;i<=r;i++){
//            int left = calculate(l, i-1);
//            int right = calculate(i+1, r);
//            res += left*right;
//        }
//        map.put(str, res);
//        return res;
//    }
}
