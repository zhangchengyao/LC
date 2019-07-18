import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC267_PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int oddNum = 0;
        char oddChar = 'a';
        for(char c: map.keySet()) {
            if(map.get(c) % 2 != 0) {
                oddNum++;
                oddChar = c;
            }
            if(oddNum > 1) return res;
        }
        if(oddNum > 0) {
            map.put(oddChar, map.get(oddChar) - 1);
            if(map.get(oddChar) == 0) map.remove(oddChar);
        }
        generatePalindromes(oddNum == 0 ? "" : "" + oddChar, map, res);
        return res;
    }

    private void generatePalindromes(String tmp, HashMap<Character, Integer> map, List<String> res) {
        boolean allZero = true;
        for(char c: map.keySet()) {
            if(map.get(c) > 0) {
                map.put(c, map.get(c) - 2);
                generatePalindromes(c + tmp + c, map, res);
                map.put(c, map.get(c) + 2);
                allZero = false;
            }
        }

        if(allZero) {
            res.add(tmp);
        }
    }
}
