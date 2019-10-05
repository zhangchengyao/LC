public class LC878_NthMagicalNumber {
    public int nthMagicalNumber(int N, int A, int B) {
        int mod = 1_000_000_007;

        int L = A / gcd(A, B) * B;

        long left = 1;
        long right = (long)1e15;
        while(left < right) {
            long mid = left + (right - left) / 2;

            if(mid / A + mid / B - mid / L >= N) right = mid;
            else left = mid + 1;
        }

        return (int) (left % mod);
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
