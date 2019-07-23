import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC320_GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        HashSet<String> set = new HashSet<>();
        if(word == null) return new ArrayList<>();

        abbreviate(word, 0, "", set, true);

        return new ArrayList<>(set);
    }

    private void abbreviate(String word, int start, String tmp, HashSet<String> res, boolean leadingNum) {
        if(start == word.length()) {
            res.add(tmp);
            return;
        }
        for(int i = start + 1; i <= word.length(); i++) {
            abbreviate(word, i, tmp + word.substring(start, i), res, true);
            if(leadingNum) {
                abbreviate(word, i, tmp + (i - start), res, false);
            }
        }
    }
}
