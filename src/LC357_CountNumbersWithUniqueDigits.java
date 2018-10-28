public class LC357_CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int res = 0;
        for(int i=1;i<=n;i++){
            if(i>9) break;
            if(i==1) res+=10;
            else{
                int tmp = 9;
                for(int j=1;j<i;j++){
                    tmp *= (10-j);
                }
                res += tmp;
            }
        }
        return res;
    }
}
