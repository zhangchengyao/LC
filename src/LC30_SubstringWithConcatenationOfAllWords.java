import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC30_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s==null || s.length()==0 || words.length==0) return res;
        int len = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        int cnt = 0;
        HashMap<String, Integer> tmp = new HashMap<>();
        for(int start=0;start<=s.length()-len*words.length;start++){
            if(!map.containsKey(s.substring(start, start+len))) continue;
            tmp.clear();
            cnt = 0;
            for(int i=start;i+len<=s.length();i+=len){
                String str = s.substring(i, i+len);
                if(map.containsKey(str)){
                    tmp.put(str, tmp.getOrDefault(str, 0)+1);
                    if(tmp.get(str)==map.get(str)) cnt++;
                    else if(tmp.get(str)>map.get(str)) break;
                    if(cnt==map.size()){
                        res.add(start);
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        return res;
    }
}
