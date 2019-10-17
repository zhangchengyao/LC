import java.util.HashSet;
import java.util.Set;

public class LC804_UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-", "-...", "-.-.", "-..", ".",
                                    "..-.", "--.", "....", "..", ".---",
                                    "-.-", ".-..", "--", "-.", "---",
                                    ".--.", "--.-", ".-.", "...", "-",
                                    "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();

        for(String word: words){
            StringBuilder sb = new StringBuilder();
            for(char c: word.toCharArray()){
                sb.append(codes[c - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
