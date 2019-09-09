import java.util.HashMap;
import java.util.HashSet;

public class LC1153_StringTransformsIntoAnotherString {
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;
        if(str1.length() != str2.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < str1.length(); i++) {
            char from = str1.charAt(i);
            char to = str2.charAt(i);
            map.putIfAbsent(from, to);
            if(map.get(from) != to) return false;
        }

        return map.size() < 26 || new HashSet<>(map.values()).size() < 26;
    }
}
