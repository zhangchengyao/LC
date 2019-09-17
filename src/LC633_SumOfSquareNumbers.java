public class LC633_SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for(int i = 0; i <= Math.sqrt(c); i++) {
            int b = c - i * i;
            int bSqrt = (int)Math.sqrt(b);
            if(bSqrt * bSqrt == b) return true;
        }

        return false;
    }
}
