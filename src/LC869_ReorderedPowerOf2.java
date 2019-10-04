import java.util.Arrays;

public class LC869_ReorderedPowerOf2 {
    // Permutation
    public boolean reorderedPowerOf2(int N) {
        int[] digits = new int[10];
        Arrays.fill(digits, -1);

        int i = 0;
        while(N > 0) {
            digits[i++] = N % 10;
            N /= 10;
        }

        return reorder(digits, 0);
    }

    private boolean reorder(int[] digits, int start) {
        if(digits[start] == -1) return isPowerOf2(digits);

        for(int i = start; i < digits.length; i++) {
            if(digits[i] == -1) break;

            swap(digits, start, i);

            if(reorder(digits, start + 1)) return true;

            swap(digits, start, i);
        }

        return false;
    }

    private boolean isPowerOf2(int[] digits) {
        if(digits[0] == 0) return false;

        int num = 0;
        for(int i = 0; digits[i] != -1; i++) {
            num = digits[i] + 10 * num;
        }

        return (num & -num) == num;
    }

    private void swap(int[] digits, int i, int j) {
        int tmp = digits[i];
        digits[i] = digits[j];
        digits[j] = tmp;
    }
}
