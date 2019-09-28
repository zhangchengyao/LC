import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC816_AmbiguousCoordinates {
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> ambiguousCoordinates(String S) {
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()) {
            if(Character.isDigit(c)) sb.append(c);
        }
        S = sb.toString();

        List<String> res = new ArrayList<>();
        for(int split = 1; split < S.length(); split++) {
            List<String> xs = helper(S.substring(0, split));
            List<String> ys = helper(S.substring(split));
            for(String x: xs) {
                for(String y: ys) {
                    res.add("(" + x + ", " + y + ")");
                }
            }
        }

        return res;
    }

    private List<String> helper(String s) {
        if(memo.containsKey(s)) return memo.get(s);

        List<String> res = new ArrayList<>();
        if(s.length() == 1 || s.charAt(0) != '0') res.add(s);

        if(s.charAt(s.length() - 1) != '0') {
            for(int i = 1; i < s.length(); i++) {
                if(i > 1 && s.charAt(0) == '0') break;
                res.add(s.substring(0, i) + "." + s.substring(i));
            }
        }

        memo.put(s, res);
        return res;
    }
}
