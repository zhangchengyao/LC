public class LC670_MaximumSwap {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] largestRight = new int[digits.length];
        largestRight[digits.length - 1] = digits.length - 1;
        for(int i = digits.length - 2; i >= 0; i--) {
            if(digits[i] > digits[largestRight[i + 1]]) {
                largestRight[i] = i;
            } else {
                largestRight[i] = largestRight[i + 1];
            }
        }

        for(int i = 0; i < digits.length; i++) {
            if(digits[largestRight[i]] != digits[i]) {
                char tmp = digits[largestRight[i]];
                digits[largestRight[i]] = digits[i];
                digits[i] = tmp;
                break;
            }
        }

        int res = 0;
        for(char c: digits) {
            int n = c - '0';
            res = n + 10 * res;
        }

        return res;
    }
}
