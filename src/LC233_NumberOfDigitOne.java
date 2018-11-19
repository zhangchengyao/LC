public class LC233_NumberOfDigitOne {
    // todo difficult to understand
    public int countDigitOne(int n) {
        long a, b;
        int res = 0;
        for(long m=1;m<=n;m*=10){
            a = n/m;
            b = n%m;
            res += ((a+8)/10*m + (a%10==1?b+1:0));
        }
        return res;
    }
}
