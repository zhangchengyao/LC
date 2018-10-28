public class LC647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++) dp[i][i] = true;
        res += s.length();
        char[] arr = s.toCharArray();
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr.length-i;j++){
                if(i==1){
                    if(arr[j]==arr[j+i]){
                        dp[j][j+i] = true;
                        res++;
                    }
                }else{
                    if(arr[j]==arr[j+i] && dp[j+1][j+i-1]){
                        dp[j][j+i] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
