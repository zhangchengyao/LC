import java.util.HashMap;

public class LC72_EditDistance {
    // dynamic programming
    public int minDistance(String word1, String word2) {
        if(word1.equals("")) return word2.length();
        if(word2.equals("")) return word1.length();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = j;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0] = i;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    // recursive solution
//    HashMap<String, Integer> map = new HashMap<>();
//    public int minDistance(String word1, String word2) {
//        String str = word1+" "+word2;
//        if(map.containsKey(str)) return map.get(str);
//        if(word1.equals(word2)) return 0;
//        if(word1.equals("")) return word2.length();
//        if(word2.equals("")) return word1.length();
//        if(word1.charAt(0)==word2.charAt(0)) return minDistance(word1.substring(1), word2.substring(1));
//        int op1 = minDistance(word1, word2.substring(1)); //insert
//        int op2 = minDistance(word1.substring(1), word2); //delete
//        int op3 = minDistance(word1.substring(1), word2.substring(1)); //replace
//        int res = Math.min(op1, Math.min(op2, op3)) + 1;
//        map.put(str, res);
//        return res;
//    }
}
