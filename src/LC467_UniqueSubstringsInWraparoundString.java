import java.util.HashSet;

public class LC467_UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[p.length()];
        int[] maxLen = new int[26];
        for(int i=p.length()-1;i>=0;i--){
            if((i==p.length()-1) || (p.charAt(i)+1!=p.charAt(i+1) && !(p.charAt(i)=='z' && p.charAt(i+1)=='a'))){
                dp[i] = 1;
            }else{
                dp[i] = dp[i+1]+1;
            }
        }
        for(int i=0;i<dp.length;i++){
            if(dp[i]>maxLen[p.charAt(i)-'a']) maxLen[p.charAt(i)-'a'] = dp[i];
        }
        int res = 0;
        for(int i=0;i<maxLen.length;i++) res += maxLen[i];
        return res;
    }
}
