public class LC788_RotatedDigits {
    public int rotatedDigits(int N) {
        int count = 0;
        for(int n = 1; n <= N; n++) {
            if(isGood(n)) count++;
        }

        return count;
    }

    private boolean isGood(int n) {
        boolean different = false;
        while(n > 0) {
            int digit = n % 10;
            if(digit == 3 || digit == 4 || digit == 7) return false;
            if(digit == 2 || digit == 5 || digit == 6 || digit == 9) different = true;
            n /= 10;
        }

        return different;
    }
}
