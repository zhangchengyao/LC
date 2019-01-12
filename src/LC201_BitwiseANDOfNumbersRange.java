public class LC201_BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0 || n==0) return 0;

        int cnt = 0;
        while(m!=n){
            m >>= 1;
            n >>= 1;
            cnt++;
        }

        for(int i=0;i<cnt;i++){
            m <<= 1;
        }

        return m;
    }
}
