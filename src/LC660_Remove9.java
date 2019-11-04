public class LC660_Remove9 {
    public int newInteger(int n) {
        int base = 1;
        int num = 0;
        while(n > 0) {
            num += (n % 9) * base;
            base *= 10;
            n /= 9;
        }

        return num;
    }
}
