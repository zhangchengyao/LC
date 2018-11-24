public class LC459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()<2) return false;
        int n = s.length();
        int p = n/2-1;
        for(;p>=0;p--){
            int len = p+1;
            if(n%len!=0) continue;
            int i = 0;
            for(;i<n/len;i++){
                if(!s.substring(0, len).equals(s.substring(len*i, len*(i+1)))) break;
            }
            if(i==n/len) return true;
        }
        return false;
    }
}
