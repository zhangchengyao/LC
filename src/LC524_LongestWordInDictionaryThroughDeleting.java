import java.util.List;
import java.util.ArrayList;

public class LC524_LongestWordInDictionaryThroughDeleting {
    class Tuple {
        String word;
        int index;
        
        public Tuple (String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
    
    public String findLongestWord(String s, List<String> dictionary) {
        ArrayList<Tuple>[] wordGroups = new ArrayList[128];
        for (String word: dictionary) {
            char c = word.charAt(0);
            if (wordGroups[c] == null) wordGroups[c] = new ArrayList<>();
            wordGroups[c].add(new Tuple(word, 0));
        }
        
        String maxStr = "";
        for (char c: s.toCharArray()) {
            if (wordGroups[c] == null) continue;
            for (int i = wordGroups[c].size() - 1; i >= 0; i--) {
                Tuple cur = wordGroups[c].get(i);
                cur.index++;
                wordGroups[c].remove(i);
                if (cur.index == cur.word.length()) {
                    if (cur.word.length() > maxStr.length() || (cur.word.length() == maxStr.length() && cur.word.compareTo(maxStr) < 0)) maxStr = cur.word;
                } else {
                    char next = cur.word.charAt(cur.index);
                    if (wordGroups[next] == null) wordGroups[next] = new ArrayList<>();
                    wordGroups[next].add(cur);
                }
            }
        }
        
        return maxStr;
    }

    // public String findLongestWord(String s, List<String> d) {
    //     HashMap<Character, List<Integer>> map = new HashMap<>();
    //     for(int i=0;i<s.length();i++){
    //         List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
    //         list.add(i);
    //         map.put(s.charAt(i), list);
    //     }
    //     int max = 0;
    //     String res = "";
    //     for(String str: d){
    //         if(isSubsequence(str, map) && (str.length()>max || (str.length()==max && str.compareTo(res)<0))){
    //             max = str.length();
    //             res = str;
    //         }
    //     }
    //     return res;
    // }
    // private boolean isSubsequence(String d, HashMap<Character, List<Integer>> map){
    //     int i = 0;
    //     int cur = 0;
    //     while(i<d.length()){
    //         List<Integer> pos = map.get(d.charAt(i));
    //         if(pos==null) return false;
    //         int index = Collections.binarySearch(pos, cur);
    //         if(index<0) index = -index-1;
    //         if(index>=pos.size()) return false;
    //         cur = pos.get(index)+1;
    //         i++;
    //     }
    //     return true;
    // }
}
