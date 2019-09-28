import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC828_UniqueLetterString {
    public int uniqueLetterString(String S) {
        int mod = 1000000007;
        int n = S.length();

        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c = S.charAt(i);
            if(map.get(c) == null) {
                map.put(c, new ArrayList<>());
                map.get(c).add(-1);
            }
            map.get(c).add(i);
        }

        for(List<Integer> indices: map.values()) {
            indices.add(n);
        }

        long res = 0;
        for(List<Integer> indices: map.values()) {
            for(int i = 1; i < indices.size() - 1; i++) {
                res += (indices.get(i) - indices.get(i - 1)) * (indices.get(i + 1) - indices.get(i)) % mod;
                res %= mod;
            }
        }

        return (int)res;
    }
}
