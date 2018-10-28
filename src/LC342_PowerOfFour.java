public class LC342_PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if(num<=0) return false;
        int test = 1;
        for(int i=0;i<16;i++){
            if((test^num)==0) return true;
            test <<= 2;
        }
        return false;
    }
}
