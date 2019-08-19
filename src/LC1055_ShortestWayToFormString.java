import java.util.ArrayList;
import java.util.Collections;

public class LC1055_ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        ArrayList<Integer>[] map = preprocess(source);

        int cnt = 1;
        int cur = 0;
        for(int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if(map[c - 'a'] == null) return -1;
            int idx = Collections.binarySearch(map[c - 'a'], cur);
            if(idx < 0) idx = -idx - 1;
            if(idx == map[c - 'a'].size()) {
                cnt++;
                cur = 0;
                i--;
            } else {
                cur = map[c - 'a'].get(idx) + 1;
            }
        }

        return cnt;
    }

    private ArrayList<Integer>[] preprocess(String src) {
        ArrayList<Integer>[] map = new ArrayList[26];
        for(int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if(map[c - 'a'] == null) map[c - 'a'] = new ArrayList<>();
            map[c - 'a'].add(i);
        }

        return map;
    }
}
