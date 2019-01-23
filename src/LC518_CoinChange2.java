public class LC518_CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] ways = new int[amount+1];
        ways[0] = 1;

        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                ways[j] += ways[j-coins[i]];
            }
        }

        return ways[amount];
    }
}
