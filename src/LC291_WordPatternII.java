import java.util.HashMap;

public class LC291_WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        return check(pattern, 0, str, 0, map);
    }

    private boolean check(String pattern, int idx, String str, int start, HashMap<Character, String> map) {
        if(idx == pattern.length() && start == str.length()) return true;
        if(idx == pattern.length() || start == str.length()) return false;

        char c = pattern.charAt(idx);
        if(map.containsKey(c)) {
            String cur = map.get(c);
            if(start + cur.length() > str.length() || !str.substring(start, start + cur.length()).equals(cur)) {
                return false;
            }
            return check(pattern, idx + 1, str, start + cur.length(), map);
        } else {
            for(int i = start + 1; i <= str.length(); i++) {
                String cand = str.substring(start, i);
                if(!map.values().contains(cand)) {
                    map.put(c, cand);
                    if(check(pattern, idx + 1, str, i, map)) return true;
                    map.remove(c);
                }
            }
        }

        return false;
    }
}
