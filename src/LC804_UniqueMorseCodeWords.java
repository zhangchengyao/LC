import java.util.HashSet;

public class LC804_UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();

        for(String word: words){
            StringBuilder sb = new StringBuilder();
            for(char c: word.toCharArray()){
                sb.append(codes[c-'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
