public class LC_62UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1) return 1;
        long numerator = 1;
        long denominator = 1;
        int a = m + n -2;
        int b = Math.min(m-1, n-1);
        int diff = a - b + 1;
        while(a>=diff){
            numerator *= a;
            a--;
        }
        while(b>=1){
            denominator *= b;
            b--;
        }
        return (int)(numerator/denominator);
    }
}
