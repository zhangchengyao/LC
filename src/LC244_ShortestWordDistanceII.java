import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC244_ShortestWordDistanceII {

    private HashMap<String, List<Integer>> word2Idx;
    private HashMap<String, HashMap<String, Integer>> map;

    public LC244_ShortestWordDistanceII(String[] words) {
        word2Idx = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            List<Integer> cur = word2Idx.getOrDefault(words[i], new ArrayList<>());
            cur.add(i);
            word2Idx.put(words[i], cur);
        }

        map = new HashMap<>();
    }

    public int shortest(String word1, String word2) {
        if(map.containsKey(word1) && map.get(word1).get(word2) != null) return map.get(word1).get(word2);
        if(map.containsKey(word2) && map.get(word2).get(word1) != null) return map.get(word2).get(word1);

        return shortestBetween(word1, word2);
    }

    private int shortestBetween(String word1, String word2) {
        List<Integer> index1 = word2Idx.get(word1);
        List<Integer> index2 = word2Idx.get(word2);

        int i = 0;
        int j = 0;
        int shortestDist = Integer.MAX_VALUE;
        while(i < index1.size() && j < index2.size()) {
            shortestDist = Math.min(shortestDist, Math.abs(index1.get(i) - index2.get(j)));
            if(index1.get(i) < index2.get(j)) i++;
            else j++;
        }
        HashMap<String, Integer> m = map.getOrDefault(word1, new HashMap<>());
        m.put(word2, shortestDist);
        map.put(word1, m);

        return shortestDist;
    }
}
