import java.util.HashMap;

public class LC44_WildcardMatching {
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
