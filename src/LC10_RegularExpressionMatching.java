import java.util.HashMap;

public class LC10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }
    private boolean match(String s, int s1, String p, int s2){
        if(s2==p.length()) return s1==s.length();
        if(s2==p.length()-1) return s1==s.length()-1 && (s.charAt(s1)==p.charAt(s2) || p.charAt(s2)=='.');
        if(p.charAt(s2+1)=='*'){
            int i = s1;
            while(i<s.length() && (s.charAt(i)==p.charAt(s2) || p.charAt(s2)=='.')){
                if(match(s, i, p, s2+2)) return true;
                i++;
            }
            return match(s, i, p, s2+2);
        }
        return s1<s.length() && (s.charAt(s1)==p.charAt(s2) || p.charAt(s2)=='.') && match(s, s1+1, p, s2+1);
    }
}
