import java.util.ArrayList;
import java.util.List;

public class LC243_ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
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
