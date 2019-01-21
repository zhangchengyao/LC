import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC500_KeyboardRow {
    public String[] findWords(String[] words) {
        HashSet<Character>[] sets = preprocess();
        List<String> oneRows = new ArrayList<>();
        for(String word: words){
            for(HashSet<Character> set: sets){
                if(contain(set, word.toLowerCase())){
                    oneRows.add(word);
                    break;
                }
            }
        }
        String[] res = new String[oneRows.size()];
        return oneRows.toArray(res);
    }

    private boolean contain(HashSet<Character> set, String word){
        for(int i=0;i<word.length();i++){
            if(!set.contains(word.charAt(i))) return false;
        }
        return true;
    }

    private HashSet<Character>[] preprocess(){
        HashSet<Character>[] sets = new HashSet[3];
        sets[0] = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        sets[1] = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        sets[2] = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        return sets;
    }
}
