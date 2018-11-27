public class LC38_CountAndSay {
    public String countAndSay(int n) {
        if(n==1) return "1";
        if(n==2) return "11";
        String cur = "11";
        for(int i=3;i<=n;i++){
            StringBuilder next = new StringBuilder();
            int p = 0;
            while(p<cur.length()){
                int q = p;
                while(q<cur.length()-1 && cur.charAt(q)==cur.charAt(q+1)) q++;
                next.append(q-p+1).append(cur.charAt(p));
                p = q+1;
            }
            cur = next.toString();
        }
        return cur;
    }
}
