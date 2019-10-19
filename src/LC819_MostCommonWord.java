import java.util.*;

public class LC819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();

        String mostComm = null;

        int i = 0;
        while(i < paragraph.length()) {
            while(i < paragraph.length() && !Character.isLetter(paragraph.charAt(i))) i++;

            if(i < paragraph.length()) {
                int j = i + 1;
                while(j < paragraph.length() && Character.isLetter(paragraph.charAt(j))) j++;

                String word = paragraph.substring(i, j).toLowerCase();
                if(!banSet.contains(word)) {
                    count.put(word, count.getOrDefault(word, 0) + 1);
                    if(mostComm == null || count.get(word) > count.get(mostComm)) mostComm = word;
                }
                i = j;
            }
        }

        return mostComm;
    }
}
