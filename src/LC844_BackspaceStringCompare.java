public class LC844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int p = S.length()-1;
        int q = T.length()-1;
        int cnt1 = 0;
        int cnt2 = 0;
        while(p>=0&&q>=0){
            if(S.charAt(p)=='#') cnt1++;
            if(T.charAt(q)=='#') cnt2++;
            if(cnt1>0 && cnt2>0){
                if(S.charAt(p)!='#') cnt1--;
                if(T.charAt(q)!='#') cnt2--;
                p--;
                q--;
            }
            else if(cnt1>0){
                if(S.charAt(p)!='#') cnt1--;
                p--;
            }
            else if(cnt2>0){
                if(T.charAt(q)!='#') cnt2--;
                q--;
            }
            else{
                if(S.charAt(p)!=T.charAt(q)) return false;
                p--;
                q--;
            }
        }
        if(p<0){
            while(q>=0){
                if(T.charAt(q)=='#') cnt2++;
                else cnt2--;
                if(cnt2<0) return false;
                q--;
            }
        }
        else{
            while(p>=0){
                if(S.charAt(p)=='#') cnt1++;
                else cnt1--;
                if(cnt1<0) return false;
                p--;
            }
        }
        return true;
    }
}
