import java.util.ArrayList;
import java.util.List;

public class LC245_ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(word1.equals(word2)) return shortestBetweenSameWords(words, word1);
        else return shortestBetweenDifferentWords(words, word1, word2);
    }

    private int shortestBetweenSameWords(String[] words, String word) {
        int prev = 0;
        while(!words[prev].equals(word)) prev++;

        int cur = prev + 1;
        int shortest = Integer.MAX_VALUE;
        while(cur < words.length) {
            if(words[cur].equals(word)) {
                shortest = Math.min(shortest, cur - prev);
                prev = cur;
            }
            cur++;
        }

        return shortest;
    }

    private int shortestBetweenDifferentWords(String[] words, String word1, String word2) {
        List<Integer> index1 = new ArrayList<>();
        List<Integer> index2 = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) index1.add(i);
            else if(words[i].equals(word2)) index2.add(i);
        }

        int i = 0;
        int j = 0;
        int shortestDist = Integer.MAX_VALUE;
        while(i < index1.size() && j < index2.size()) {
            shortestDist = Math.min(shortestDist, Math.abs(index1.get(i) - index2.get(j)));
            if(index1.get(i) < index2.get(j)) i++;
            else j++;
        }
        return shortestDist;
    }
}
