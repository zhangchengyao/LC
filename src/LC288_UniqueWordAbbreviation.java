import java.util.HashMap;
import java.util.HashSet;

public class LC288_UniqueWordAbbreviation {
    private HashMap<String, String> map;

    public LC288_UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        for(String word: dictionary) {
            String abbr = word.length() > 2 ? word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1) : word;
            if(map.get(abbr) != null && !map.get(abbr).equals(word)) map.put(abbr, "*");
            else map.put(abbr, word);
        }
    }

    public boolean isUnique(String word) {
        String abbr = word.length() > 2 ? word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1) : word;

        if(!map.containsKey(abbr) || map.get(abbr).equals(word)) return true;
        else return false;
    }
}
