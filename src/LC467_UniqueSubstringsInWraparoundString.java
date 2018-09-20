import java.util.HashSet;

public class LC467_UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int[][] dp = new int[p.length()][p.length()];
        HashSet<String> set = new HashSet<>();
        int res = 0;
        for(int i=0;i<dp.length;i++){
            dp[i][i] = 1;
            if(!set.contains(p.substring(i, i+1))){
                set.add(p.substring(i, i+1));
                res++;
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=i+1;j<dp.length;j++){
                if(dp[i][j-1]==1){
                    if((p.charAt(j)==(p.charAt(j-1)+1)) || (p.charAt(j)=='a' && p.charAt(j-1)=='z')){
                        dp[i][j] = 1;
                        if(!set.contains(p.substring(i, j+1))){
                            set.add(p.substring(i, j+1));
                            res++;
                        }
                    }
                }else{
                    break;
                }
            }
        }
        return res;
    }
}
