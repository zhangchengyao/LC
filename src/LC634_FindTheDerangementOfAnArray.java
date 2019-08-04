public class LC634_FindTheDerangementOfAnArray {
    // using formula
    public int findDerangement(int n) {
        long mul = 1;
        long sum = 0;
        int mod = 1000000007;
        for(int i = n; i >= 0; i--) {
            sum = (sum + mul * (i % 2 == 0 ? 1 : -1) + mod) % mod;
            mul = (mul * i) % mod;
        }

        return (int)sum;
    }
}
