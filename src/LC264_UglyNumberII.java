public class LC264_UglyNumberII {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] res = new int[n];
        int c = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        res[0] = 1;
        while(c<n){
            int mul2 = res[i2] * 2;
            int mul3 = res[i3] * 3;
            int mul5 = res[i5] * 5;
            int min = Math.min(mul2, Math.min(mul3, mul5));
            if(mul2==min) i2++;
            if(mul3==min) i3++;
            if(mul5==min) i5++;
            res[c] = min;
            c++;
        }
        return res[n-1];
    }
}
