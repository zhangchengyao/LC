public class LC829_ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int res = 0;
        // N = (x + 1) + (x + 2) + (x + 3) + ... + (x + k)
        // 2 * N = k * (2 * x + k + 1)
        for(int k = 1; k <= Math.sqrt(2 * N); k++) {
            if((2 * N) % k == 0) {
                int x2 = 2 * N / k - k - 1;
                if(x2 % 2 == 0) res++;
            }
        }

        return res;
    }
}
