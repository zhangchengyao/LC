public class LC650_2KeysKeyboard {
    // prime factorization
    // N = g_1 * g_2 * g_3 * ... * g_n where g_i is prime number
    public int minSteps(int n) {
        int res = 0;
        int d = 2;
        while(n > 1) {
            while(n % d == 0) {
                res += d;
                n /= d;
            }
            d++;
        }

        return res;
    }
}
