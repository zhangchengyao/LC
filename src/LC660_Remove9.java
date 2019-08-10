public class LC660_Remove9 {
    public int newInteger(int n) {
        int base = 1;
        int sum = 0;
        while(n > 0) {
            sum += (n % 9) * base;
            base *= 10;
            n /= 9;
        }

        return sum;
    }
}
