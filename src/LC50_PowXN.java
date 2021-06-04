public class LC50_PowXN {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1;
        if (n < 0) return 1 / (x * myPow(x, -(n + 1)));
        double half = myPow(x, n / 2);
        if ((n & 1) == 1) return x * half * half;
        else return half * half;
    }
}
