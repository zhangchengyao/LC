import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC336_PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i], i);
        }
        for(int i=0;i<words.length;i++){
            String cur = words[i];
            if(!cur.equals("") && check(cur) && map.containsKey("")){
                res.add(Arrays.asList(i, map.get("")));
                res.add(Arrays.asList(map.get(""), i));
            }
            StringBuilder sb = new StringBuilder(cur);
            String rev = sb.reverse().toString();
            if(map.containsKey(rev) && map.get(rev)!=i){
                res.add(Arrays.asList(i, map.get(rev)));
            }
            for(int j=1;j<cur.length();j++){
                if(check(cur.substring(0, j))){
                    sb = new StringBuilder(cur.substring(j));
                    rev = sb.reverse().toString();
                    if(map.containsKey(rev)) res.add(Arrays.asList(map.get(rev), i));
                }
            }
            for(int j=cur.length()-1;j>0;j--){
                if(check(cur.substring(j))){
                    sb = new StringBuilder(cur.substring(0, j));
                    rev = sb.reverse().toString();
                    if(map.containsKey(rev)) res.add(Arrays.asList(i, map.get(rev)));
                }
            }
        }
        return res;
    }
    private boolean check(String s){
        if(s.equals("")) return true;
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
