public class LC231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        int count = 0;
        while(n!=0){
            if((n&1)==1) count++;
            n >>>= 1;
        }
        return count==1;
    }
}
