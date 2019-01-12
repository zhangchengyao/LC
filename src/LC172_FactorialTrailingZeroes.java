public class LC172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if(n<2) return 0;

        int count = 0;
        while(n>4){
            count += n/5;
            n /= 5;
        }
        return count;
    }
}
