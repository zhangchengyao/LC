public class LC809_ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for(String word: words){
            int i = 0;
            int j = 0;
            while(i<S.length() && j<word.length()){
                if(S.charAt(i)==word.charAt(j)){
                    int p = i+1;
                    int q = j+1;
                    while(p<S.length() && S.charAt(p)==S.charAt(i)) p++;
                    while(q<word.length() && word.charAt(q)==word.charAt(j)) q++;
                    if(p-i==q-j || (p-i>=3&&p-i>q-j)){
                        i = p;
                        j = q;
                    }
                    else break;
                }
                else break;
            }
            if(i==S.length() && j==word.length()) res++;
        }
        return res;
    }
}
