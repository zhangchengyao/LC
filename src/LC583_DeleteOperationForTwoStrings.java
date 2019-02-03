public class LC583_DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j-1], dp[i-1][j]));
            }
        }

        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}
