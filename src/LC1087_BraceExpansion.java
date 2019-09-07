import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC1087_BraceExpansion {
    public String[] expand(String S) {
        StringBuilder pattern = new StringBuilder();
        HashMap<Integer, String[]> options = new HashMap<>();
        int pos = 0;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '{') {
                pattern.append("*");
                int j = S.indexOf("}", i + 1);
                options.put(pos, S.substring(i + 1, j).split(","));
                Arrays.sort(options.get(pos));
                i = j;
            } else {
                pattern.append(S.charAt(i));
            }
            pos++;
        }

        List<String> res = new ArrayList<>();
        construct(pattern, 0, options, res);

        String[] resArray = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    private void construct(StringBuilder pattern, int pos, HashMap<Integer, String[]> options, List<String> res) {
        if(pos == pattern.length()) {
            res.add(pattern.toString());
            return;
        }

        if(pattern.charAt(pos) == '*') {
            for(String opt: options.get(pos)) {
                pattern.setCharAt(pos, opt.charAt(0));
                construct(pattern, pos + 1, options, res);
            }
            pattern.setCharAt(pos, '*');
        } else {
            construct(pattern, pos + 1, options, res);
        }
    }
}
