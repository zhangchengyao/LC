public class LC837_New21Game {
    public double new21Game(int N, int K, int W) {
        if(K>N) return 0.0;
        double[] dp = new double[K+W];
        double[] sum = new double[K+W+1];
        for(int i=dp.length-1;i>=0;i--){
            if(i>N) continue;
            if(i>=K) dp[i] = 1.0;
            else{
                dp[i] += (sum[i+1]-sum[i+1+W])/W;
            }
            sum[i] += dp[i]+sum[i+1];
        }
        return dp[0];
    }
}
