public class LC483_SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        // k^0 + k^1 + k^2 + ... + k^(m-1) = num
        // when k is smallest, m is largest
        for(int m = (int)(Math.log(num+1)/Math.log(2) );m>=2;m--){
            int k = (int)Math.pow(num, 1.0/(m-1) );
            long sum = 0L;
            for(int i=0;i<m;i++) sum = sum * k + 1;
            if( sum==num ) return String.valueOf(k);
        }

        return String.valueOf(num-1);
    }
}
