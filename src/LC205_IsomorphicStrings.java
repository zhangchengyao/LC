import java.util.HashMap;

public class LC205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder sbs = new StringBuilder(s);
        StringBuilder sbt = new StringBuilder(t);
        for(int i=0;i<s.length();i++){
            if(map.containsKey(sbs.charAt(i))){
                if(map.get(sbs.charAt(i))==sbt.charAt(i)){
                    sbs.setCharAt(i, sbt.charAt(i));
                }
                else return false;
            }else{
                if(map.containsValue(sbt.charAt(i))) return false;
                map.put(sbs.charAt(i), sbt.charAt(i));
                sbs.setCharAt(i, sbt.charAt(i));
            }
        }
        return sbs.toString().equals(sbt.toString());
    }
}
