import java.util.HashMap;
import java.util.HashSet;

public class LC753_CrackingTheSafe {
    HashSet<String> set = new HashSet<>();
    public String crackSafe(int n, int k) {
        StringBuilder res = new StringBuilder();
        check(res, n, k);
        return res.toString();
    }
    private boolean check(StringBuilder res, int n, int k){
        if(res.length()==((int)Math.pow(k, n)+n-1)) return true;
        String s = res.toString();
        for(int i=0;i<k;i++){
            res.append(i);
            if(res.length()>=n){
                if(set.contains(res.substring(res.length()-n))){
                    res.deleteCharAt(res.length()-1);
                    continue;
                }
                set.add(res.substring(res.length()-n));
            }
            boolean suc = check(res, n, k);
            if(suc){
                return true;
            }else{
                set.remove(res.substring(res.length()-n));
                res.deleteCharAt(res.length()-1);
            }
        }
        return false;
    }
}
