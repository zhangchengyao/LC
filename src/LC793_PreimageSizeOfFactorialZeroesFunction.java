public class LC793_PreimageSizeOfFactorialZeroesFunction {
    public int preimageSizeFZF(int K) {
        long left = 0;
        long right = 5L * (K + 1);
        while(left < right) {
            long mid = left + (right - left) / 2;
            long cnt = countTrailingZero(mid);
            if(cnt == K) return 5;
            else if(cnt < K) left = mid + 1;
            else right = mid;
        }

        return 0;
    }

    private long countTrailingZero(long x) {
        long cnt = 0;
        while(x > 0) {
            cnt += x / 5;
            x /= 5;
        }

        return cnt;
    }
}
