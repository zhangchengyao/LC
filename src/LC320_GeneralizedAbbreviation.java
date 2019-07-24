import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC320_GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        if(word == null) return list;

        abbreviate(word, 0, 0, "", list);

        return list;
    }

    private void abbreviate(String word, int cur, int cnt, String tmp, List<String> res) {
        if(cur == word.length()) {
            if(cnt > 0) tmp += cnt;
            res.add(tmp);
            return;
        }
        abbreviate(word, cur + 1, cnt + 1, tmp, res);

        // not abbreviate
        if(cnt > 0) {
            abbreviate(word, cur + 1, 0, tmp + cnt + word.charAt(cur), res);
        } else {
            abbreviate(word, cur + 1, 0, tmp + word.charAt(cur), res);
        }
    }
}
