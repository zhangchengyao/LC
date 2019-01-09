import java.util.ArrayList;
import java.util.List;

public class LC93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restore(s, new StringBuilder(), 4, res);
        return res;
    }

    private void restore(String s, StringBuilder ip, int remain, List<String> res){
        if(s.equals("") || s.length()>3*remain) return;

        if(remain==1){
            int val = Integer.parseInt(s);
            if(s.length()==1 || (val<=255 && s.charAt(0)!='0')){
                ip.append(s);
                res.add(ip.toString());
                ip.delete(ip.length()-s.length(), ip.length());
            }
            return ;
        }

        for(int i=1;i<=Math.min(3, s.length());i++){
            String cur = s.substring(0, i);
            if(Integer.parseInt(cur)>255 || (i>1 && cur.charAt(0)=='0')) break;

            ip.append(cur).append(".");
            restore(s.substring(i), ip, remain-1, res);
            ip.delete(ip.length()-i-1, ip.length());
        }
    }
}
