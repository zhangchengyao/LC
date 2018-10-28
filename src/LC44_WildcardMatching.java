import java.util.HashMap;

public class LC44_WildcardMatching {
    // dynamic programming
//    public boolean isMatch(String s, String p) {
//        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
//        dp[0][0] = true;
//        for(int i=1;i<p.length()+1;i++) dp[0][i] = dp[0][i-1]&&p.charAt(i-1)=='*';
//        for(int i=1;i<s.length()+1;i++){
//            for(int j=1;j<p.length()+1;j++){
//                if(p.charAt(j-1)!='*') dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?');
//                else dp[i][j] = dp[i-1][j] || dp[i][j-1];
//            }
//        }
//        return dp[s.length()][p.length()];
//    }
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isMatch(String s, String p) {
        StringBuilder sb = new StringBuilder(p);
        for(int i=0;i<sb.length()-1;i++){
            if(sb.charAt(i)=='*' && sb.charAt(i+1)=='*'){
                sb.deleteCharAt(i);
                i--;
            }
        }
        return match(s, 0, sb.toString(), 0);
    }
    private boolean match(String s, int start1, String p, int start2){
        String str = start1+" "+start2;
        if(map.containsKey(str)) return map.get(str);
        boolean res = false;
        if(start2==p.length()){
            res = start1==s.length();
            map.put(str, res);
            return res;
        }
        if(start2==p.length()-1){
            res = p.charAt(start2)=='*' || (start1==s.length()-1 &&(p.charAt(start2)=='?'||p.charAt(start2)==s.charAt(start1)));
            map.put(str, res);
            return res;
        }
        if(p.charAt(start2)=='*'){
            for(int i=start1;i<=s.length();i++){
                if(match(s, i, p, start2+1)){
                    map.put(str, true);
                    return true;
                }
            }
            map.put(str, false);
            return false;
        }
        if(start1>=s.length()){
            map.put(str, false);
            return false;
        }
        if(p.charAt(start2)=='?'||p.charAt(start2)==s.charAt(start1)){
            res = match(s, start1+1, p, start2+1);
            map.put(str, res);
            return res;
        }
        map.put(str, false);
        return false;
    }
}
