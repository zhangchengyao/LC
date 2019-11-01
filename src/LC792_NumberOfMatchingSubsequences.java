import java.util.*;

public class LC792_NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            List<Integer> list = map.getOrDefault(S.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(S.charAt(i), list);
        }

        int res = 0;
        for(String word: words){
            if(isSubsequence(map, word)) res++;
        }

        return res;
    }
    private boolean isSubsequence(Map<Character, List<Integer>> map, String t){
        int cur = 0;
        for(int i = 0; i < t.length(); i++){
            List<Integer> list = map.get(t.charAt(i));
            if(list == null) return false;
            int idx = Collections.binarySearch(list, cur);
            if(idx < 0) idx = -idx - 1;
            if(idx == list.size()) return false;
            cur = list.get(idx) + 1;
        }
        return true;
    }
}
