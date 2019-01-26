import java.util.HashMap;
import java.util.HashSet;

public class LC819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>();
        for(String word: banned){
            set.add(word.toLowerCase());
        }

        HashMap<String, Integer> count = new HashMap<>();
        int max = 0;
        String res = "";
        int i = 0;
        while(i<paragraph.length()){
            if(!Character.isLetter(paragraph.charAt(i))) i++;
            else {
                int j = i + 1;
                while(j<paragraph.length() && Character.isLetter(paragraph.charAt(j))) j++;

                String word = paragraph.substring(i, j).toLowerCase();
                if(!set.contains(word)){
                    count.put(word, count.getOrDefault(word, 0)+1);
                    if(count.get(word)>max){
                        max = count.get(word);
                        res = word;
                    }
                }

                i = j + 1;
            }
        }

        return res;
    }
}
