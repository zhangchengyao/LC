public class LC233_NumberOfDigitOne {
    // understandable solution
    public int countDigitOne(int n) {
        int res = 0;
        for(long factor = 1; factor <= n; factor *= 10){
            long cur = (n / factor) %10 ;
            long low = n % factor;
            long high = n / (factor * 10);
            if(cur < 1) res += high * factor;
            else if(cur == 1) res += high * factor + low + 1;
            else res += (high + 1) * factor;
        }
        return res;
    }

//    public int countDigitOne(int n) {
//        long a, b;
//        int res = 0;
//        for(long m=1;m<=n;m*=10){
//            a = n/m;
//            b = n%m;
//            res += ((a+8)/10*m + (a%10==1?b+1:0));
//        }
//        return res;
//    }
}
