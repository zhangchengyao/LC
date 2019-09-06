import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC1065_IndexPairsOfAString {
    public int[][] indexPairs(String text, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for(String word: words) {
            int len = word.length();
            minLen = Math.min(minLen, len);
            maxLen = Math.max(maxLen, len);
            wordSet.add(word);
        }

        List<int[]> pairs = new ArrayList<>();

        for(int i = 0; i <= text.length() - minLen; i++) {
            for(int j = i + minLen; j <= text.length(); j++) {
                if(wordSet.contains(text.substring(i, j))) {
                    pairs.add(new int[]{i, j - 1});
                }
            }
        }

        int[][] res = new int[pairs.size()][2];
        for(int i = 0; i < pairs.size(); i++) {
            res[i] = pairs.get(i);
        }

        return res;
    }
}
