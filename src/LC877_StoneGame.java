public class LC877_StoneGame {
    public boolean stoneGame(int[] piles) {
        int[][] score = new int[piles.length][piles.length];
        for(int i=0;i<score.length;i++) score[i][i] = piles[i];
        for(int j=1;j<piles.length;j++){
            for(int i=j-1;i>=0;i--){
                score[i][j] = Math.max(piles[i]-score[i+1][j], piles[j]-score[i][j-1]);
            }
        }
        return score[0][piles.length-1]>0;
    }
}
