public class LC248_StrobogrammaticNumberIII {
    int res = 0;
    char[] cs = new char[]{'0','1','6','8','9'};
    public int strobogrammaticInRange(String low, String high){
        for(int i=low.length();i<=high.length();i++){
            find(i, "", low, high);
        }
        return res;
    }
    private void find(int n, String tmp, String low, String high){
        if(n==tmp.length()){
            if(n==low.length()){
                if(low.compareTo(tmp)<0) res++;
            }else if(n==high.length()){
                if(high.compareTo(tmp)>0) res++;
            }else res++;
            return ;
        }
        for(int i=0;i<cs.length;i++){
            char c = cs[i];
            if((c=='0'&&tmp.length()==0&&n!=1) || ((c=='6'||c=='9')&&tmp.length()==n-1)) continue;
            StringBuilder sb = new StringBuilder(tmp);
            if(c=='6') sb.insert(tmp.length()/2, "69");
            else if(c=='9') sb.insert(tmp.length()/2, "96");
            else{
                if(tmp.length()==n-1) sb.insert(tmp.length()/2, c);
                else sb.insert(tmp.length()/2, c+""+c);
            }
            find(n, sb.toString(), low, high);
        }
    }
}
