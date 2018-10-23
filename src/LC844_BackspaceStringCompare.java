public class LC844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int p = S.length()-1;
        int q = T.length()-1;
        int cnt1 = 0;
        int cnt2 = 0;
        while(p>=0&&q>=0){
            if(S.charAt(p)=='#') cnt1++;
            if(T.charAt(q)=='#') cnt2++;
            if(cnt1==0){
                if(cnt2==0){
                    if(S.charAt(p)!=T.charAt(q)) return false;
                    p--;
                    q--;
                }
                else{
                    if(T.charAt(q)!='#'){
                        q--;
                        cnt2--;
                    }
                    else q--;
                }
            }
            else if(cnt2==0){
                if(S.charAt(p)!='#'){
                    p--;
                    cnt1--;
                }
                else p--;
            }
            else{
                p--;
                q--;
            }
        }
        return true;
    }
}