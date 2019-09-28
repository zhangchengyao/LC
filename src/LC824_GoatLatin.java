import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC824_GoatLatin {
    private String suffix = "ma";
    private Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder a = new StringBuilder("a");

        for(String word: words) {
            if(vowels.contains(word.charAt(0))) {
                sb.append(word);
            } else {
                sb.append(word.substring(1)).append(word.charAt(0));
            }
            sb.append(suffix).append(a).append(" ");
            a.append("a");
        }

        return sb.toString().trim();
    }
}
