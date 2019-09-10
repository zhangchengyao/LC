public class LC1134_ArmstrongNumber {
    public boolean isArmstrong(int N) {
        int k = Integer.toString(N).length();
        long sum = 0;
        int number = N;
        while(N > 0) {
            int digit = N % 10;
            sum += Math.pow(digit, k);
            if(sum > number) return false;
            N /= 10;
        }

        return sum == number;
    }
}
