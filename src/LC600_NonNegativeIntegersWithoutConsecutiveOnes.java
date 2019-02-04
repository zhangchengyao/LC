public class LC600_NonNegativeIntegersWithoutConsecutiveOnes {
    public int findIntegers(int num) {
        int[] memo = new int[32];
        memo[0] = 1;
        memo[1] = 2;
        for(int i = 2; i < memo.length; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }

        int k = 31;
        int prev = 0;
        int res = 0;
        while(k >= 0){
            if(((num >> k) & 1) == 1){
                res += memo[k];
                if(prev == 1) return res;
                prev = 1;
            } else {
                prev = 0;
            }
            k--;
        }
        return res + 1;
    }
}
