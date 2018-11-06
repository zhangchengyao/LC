import java.util.ArrayList;
import java.util.List;

public class LC282_ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(num, target, 0, 0, "", res);
        return res;
    }
    private void dfs(String num, long target, long curNum, long last, String tmp, List<String> res){
        if(num.equals("") && target==curNum) res.add(tmp);
        for(int i=0;i<num.length();i++){
            long val = Long.parseLong(num.substring(0, i+1));
            if(num.charAt(0)=='0' && i>0) return;
            String substr = num.substring(i+1);
            if(tmp.length()==0){
                dfs(substr, target, val, val, val+"", res);
            }
            else{
                dfs(substr, target, curNum+val, val, tmp+"+"+val, res);
                dfs(substr, target, curNum-val, -val, tmp+"-"+val, res);
                dfs(substr, target, curNum-last+last*val, last*val, tmp+"*"+val, res);
            }
        }
    }
}
