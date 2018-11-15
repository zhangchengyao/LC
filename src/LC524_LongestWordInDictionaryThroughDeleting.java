import java.util.*;

public class LC524_LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(s.charAt(i), list);
        }
        int max = 0;
        String res = "";
        for(String str: d){
            if(isSubsequence(str, map) && (str.length()>max || (str.length()==max && str.compareTo(res)<0))){
                max = str.length();
                res = str;
            }
        }
        return res;
    }
    private boolean isSubsequence(String d, HashMap<Character, List<Integer>> map){
        int i = 0;
        int cur = 0;
        while(i<d.length()){
            List<Integer> pos = map.get(d.charAt(i));
            if(pos==null) return false;
            int index = Collections.binarySearch(pos, cur);
            if(index<0) index = -index-1;
            if(index>=pos.size()) return false;
            cur = pos.get(index)+1;
            i++;
        }
        return true;
    }
}
