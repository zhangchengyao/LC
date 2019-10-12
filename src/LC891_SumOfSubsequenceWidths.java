import java.util.Arrays;

public class LC891_SumOfSubsequenceWidths {
    // difficult to think of
    public int sumSubseqWidths(int[] A) {
        int mod = 1_000_000_007;

        Arrays.sort(A);

        long[] pow2 = new long[A.length];
        pow2[0] = 1;
        for(int i = 1; i < pow2.length; i++) pow2[i] = (pow2[i - 1] << 1) % mod;

        long res = 0;
        for(int i = 0; i < A.length; i++) {
            res = (res + ((pow2[i] - pow2[A.length - i - 1]) * A[i]) % mod) % mod;
        }

        return (int)res;
    }
}
