public class LC371_SumofTwoIntegers {
    // a really tricky solution
    public int getSum(int a, int b) {
        while(b!=0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
