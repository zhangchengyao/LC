public class LC686_RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int res = 1;
        StringBuilder str = new StringBuilder(A);
        while(str.length() < B.length()){
            str.append(A);
            res++;
        }
        if(str.indexOf(B) == -1){
            str.append(A);
            if(str.indexOf(B) == -1) res = -1;
            else res ++;
        }
        return res;
    }
}
