import java.util.HashMap;

public class LC389_FindTheDifference {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char c = ' ';
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c, 1);
            else{
                map.put(c, map.get(c)+1);
            }
        }
        for(int i=0;i<t.length();i++){
            c = t.charAt(i);
            if(!map.containsKey(c)) break;
            if(map.get(c)==1) map.remove(c);
            else map.put(c, map.get(c)-1);
        }
        return c;
    }
}
