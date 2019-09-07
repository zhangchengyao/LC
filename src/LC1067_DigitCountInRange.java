public class LC1067_DigitCountInRange {
    public int digitsCount(int d, int low, int high) {
        return digitsCount(d, high) - digitsCount(d, low - 1);
    }

    private int digitsCount(int d, int n) {
        int res = 0;

        for(int fac = 1; fac <= n; fac *= 10) {
            int cur = (n / fac) % 10;
            int low = n % fac;
            int high = n / (fac * 10);

            if(d == 0) high -= 1;

            if(cur > d) {
                res += (high + 1) * fac;
            } else if(cur == d) {
                res += high * fac + low + 1;
            } else {
                res += high * fac;
            }
        }

        return res;
    }
}
