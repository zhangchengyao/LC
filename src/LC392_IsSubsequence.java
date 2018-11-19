public class LC392_IsSubsequence {
//    public boolean isSubsequence(String s, String t) {
//        int idx = 0;
//        for(int i=0;i<s.length();i++){
//            while(idx<t.length() && t.charAt(idx)!=s.charAt(i)) idx++;
//            if(idx>=t.length()) return false;
//            idx++;
//        }
//        return true;
//    }
    public boolean isSubsequence(String s, String t) {
        return isSubsequenceRec(s, 0, t, 0);
    }
    private boolean isSubsequenceRec(String s, int cur, String t, int start){
        if(cur==s.length()) return true;
        int i = start;
        while(i<t.length() && t.charAt(i)!=s.charAt(cur)) i++;
        if(i==t.length()) return false;
        return isSubsequenceRec(s, cur+1, t, i+1);
    }
}
