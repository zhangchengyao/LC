import java.util.HashMap;

public class LC205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int i = 0;
        for(;i<sarr.length;i++){
            if(map.containsKey(sarr[i])){
                if(map.get(sarr[i])!=tarr[i]) return false;
            }else{
                if(map.containsValue(tarr[i])) return false;
                map.put(sarr[i], tarr[i]);
            }
        }
        return i==sarr.length;
    }
}
