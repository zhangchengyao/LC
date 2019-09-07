public class LC1085_SumOfDigitsInTheMinimumNumber {
    public int sumOfDigits(int[] A) {
        int min = A[0];
        for(int x: A) {
            min = Math.min(min, x);
        }

        int sum = 0;
        while(min > 0) {
            sum += min % 10;
            min /= 10;
        }

        return (sum & 1) == 1 ? 0 : 1;
    }
}
