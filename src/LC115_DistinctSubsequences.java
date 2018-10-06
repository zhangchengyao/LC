import java.util.HashMap;

public class LC115_DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if(s.length()<t.length()) return 0;
        if(s.length()==0) return 1;
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++) dp[i][0] = 1;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    // recursive solution
//    HashMap<String, Integer> map = new HashMap<>();
//    public int numDistinct(String s, String t) {
//        return count(s, 0, t, 0);
//    }
//    private int count(String s, int start1, String t, int start2){
//        if(start2==t.length()) return 1;
//        if(start1==s.length()) return 0;
//        if(start1==s.length()-1){
//            if(start2!=t.length()-1) return 0;
//            else return s.charAt(start1)==t.charAt(start2)?1:0;
//        }
//        String str = s.substring(start1)+" "+t.substring(start2);
//        if(map.containsKey(str)) return map.get(str);
//        int res = 0;
//        for(int i=start1;i<=s.length()-(t.length()-start2);i++){
//            if(s.charAt(i)==t.charAt(start2)) res += count(s, i+1, t, start2+1);
//        }
//        map.put(str, res);
//        return res;
//    }
}
