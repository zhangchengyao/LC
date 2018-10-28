import java.util.ArrayList;
import java.util.List;

public class LC247_StrobogrammaticNumberII {
    char[] cs = new char[]{'0','1','6','8','9'};
    public List<String> findStrobogrammatic(int n) {
        // write your code here
        List<String> res = new ArrayList<>();
        find(res, n, "");
        return res;
    }
    private void find(List<String> res, int n, String tmp){
        if(n==tmp.length()){
            res.add(tmp);
            return;
        }
        for(int i=0;i<cs.length;i++){
            char c = cs[i];
            if((c=='0'&&tmp.length()==0&&n!=1) || ((c=='6'||c=='9')&&tmp.length()==n-1)) continue;
            StringBuilder sb = new StringBuilder(tmp);
            if(c=='6') sb.insert(sb.length()/2, "69");
            else if(c=='9') sb.insert(sb.length()/2, "96");
            else{
                if(n-1==tmp.length()) sb.insert(sb.length()/2, c);
                else sb.insert(sb.length()/2, c+""+c);
            }
            find(res, n, sb.toString());
        }
    }
}
