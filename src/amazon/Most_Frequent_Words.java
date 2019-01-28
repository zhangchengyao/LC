package amazon;

import java.util.*;

public class Most_Frequent_Words {
    public static List<String> retrieveMostFrequentlyUsedWords(String text, List<String> wordsToExclude){
        HashSet<String> set = new HashSet<>();
        for(String exclude: wordsToExclude) set.add(exclude.toLowerCase());

        HashMap<String, Integer> count = new HashMap<>();
        int max = 0;
        for(int i=0;i<text.length();i++){
            if(!Character.isLetter(text.charAt(i))) continue;

            int j = i + 1;
            while(j<text.length() && Character.isLetter(text.charAt(j))) j++;

            String word = text.substring(i, j).toLowerCase();
            if(set.contains(word)) continue;

            count.put(word, count.getOrDefault(word, 0)+1);
            if(count.get(word)>max) max = count.get(word);
            i = j;
        }

        List<String> res = new ArrayList<>();
        for(String key: count.keySet()){
            if(count.get(key)==max) res.add(key);
        }

        return res;
    }

    public static void main(String[] args){
        String text = "Jane likes jane play's good dog play bad cat a a a)a ";
        System.out.println(retrieveMostFrequentlyUsedWords(text, Arrays.asList("a")));
    }
}
