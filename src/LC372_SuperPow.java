public class LC372_SuperPow {
    private int mod = 1337;

    public int superPow(int a, int[] b) {
        long res = 1;
        for(int i=b.length-1;i>=0;i--){
            res = (res * pow(a, b[i])) % mod;
            a = (int)pow(a, 10);
        }

        return (int)res;
    }

    private long pow(long a, long b){
        if(b==0) return 1;
        if(b==1) return a;

        long res = pow(a, b/2);
        res = res * res;
        res %= mod;
        if((b&1)==1){
            return (res * a) % mod;
        } else {
            return res % mod;
        }
    }
}
