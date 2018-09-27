public class LC400_NthDigit {
    public int findNthDigit(int n) {
        if(n<10) return n;
        int num_digits = 1;
        while(n>=9*(long)Math.pow(10, num_digits-1)*num_digits){
            n -= 9*(long)Math.pow(10, num_digits-1)*num_digits;
            num_digits++;
        }
        int bias = (n-1)/num_digits;
        int target = (int)Math.pow(10, num_digits-1)+bias;
        int bit = n-bias*num_digits;
        for(int i=0;i<num_digits-bit;i++){
            target /= 10;
        }
        return target%10;
    }
}
