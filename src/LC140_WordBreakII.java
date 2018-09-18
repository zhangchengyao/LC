import java.util.ArrayList;
import java.util.List;

public class LC140_WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        wordBreakRec(s, wordDict, res, new StringBuilder());
        return res;
    }
    private void wordBreakRec(String s, List<String> dict, List<String> res, StringBuilder tmp){
        if(s.equals("")){
            res.add(tmp.toString().trim());
            return;
        }
        for(int i=1;i<=s.length();i++){
            if(dict.contains(s.substring(0,i))){
                tmp.append(s.substring(0,i)+" ");
                wordBreakRec(s.substring(i), dict, res, tmp);
                tmp.delete(tmp.length()-(i+1), tmp.length());
            }
        }
    }
}
