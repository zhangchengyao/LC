import java.util.HashMap;

public class LC290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length!=pattern.length()) return false;
        HashMap<Character, String> map = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(words[i])) return false;
            }else{
                if(map.containsValue(words[i])) return false;
                map.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }
}
