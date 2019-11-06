import java.util.HashSet;
import java.util.Set;

public class LC676_ImplementMagicDictionary {
    private Set<String> set;
    private Set<String> oriSet;
    /** Initialize your data structure here. */
    public LC676_ImplementMagicDictionary() {
        set = new HashSet<>();
        oriSet = new HashSet<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String str: dict) {
            boolean found = false;
            for(int i = 0; i < str.length(); i++) {
                String tmp = str.substring(0, i) + "*" + str.substring(i + 1);
                if(set.contains(tmp)){
                    found = true;
                    for(int k = 0; k < 26; k++){
                        String word = str.substring(0, i) + (char)('a' + k) + str.substring(i + 1);
                        if(oriSet.contains(word)) {
                            oriSet.remove(word);
                            break;
                        }
                    }
                }
                else set.add(tmp);
            }
            if(!found) oriSet.add(str);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(oriSet.contains(word)) return false;
        for(int i = 0; i < word.length(); i++) {
            if(set.contains(word.substring(0, i) + "*" + word.substring(i + 1))) return true;
        }
        return false;
    }
}
