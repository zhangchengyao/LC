public class LC727_MinimumWindowSubsequence {
    // dynamic programming
    public String minWindow(String S, String T) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        for(int i = 1; i < dp[0].length; i++) dp[0][i] = -1;
        for(int i = 0; i < dp.length; i++) dp[i][0] = i;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(S.charAt(i - 1) == T.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = dp[i - 1][j];
            }
            if(dp[i][T.length()] != -1){
                if(i - dp[i][T.length()] < min){
                    min = i - dp[i][T.length()];
                    minIndex = dp[i][T.length()];
                }
            }
        }
        return minIndex == -1 ? "" : S.substring(minIndex, minIndex + min);
    }

    // double pointer
//    public String minWindow(String S, String T) {
//        if(S.length() < T.length()) return "";
//
//        int i = 0;
//        int j = 0;
//        String res = null;
//
//        while(i < S.length()) {
//            if(S.charAt(i) == T.charAt(j)) {
//                j++;
//                if(j == T.length()) {
//                    int end = i;
//                    j--;
//                    while(j >= 0) {
//                        while(S.charAt(i) != T.charAt(j)) i--;
//                        i--;
//                        j--;
//                    }
//                    i++;
//                    j++;
//                    if(res == null || end - i + 1 < res.length()) {
//                        res = S.substring(i, end + 1);
//                    }
//                }
//            }
//            i++;
//        }
//
//        return res == null ? "" : res;
//    }
}
