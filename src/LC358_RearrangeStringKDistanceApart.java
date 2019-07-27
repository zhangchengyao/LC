import java.util.*;

public class LC358_RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        if(k == 0 || k == 1) return s;

        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0){
                pq.offer(new int[]{i, count[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            List<int[]> tmp = new ArrayList<>();
            int cnt =  Math.min(k, pq.size());
            for(int i = 0; i < cnt; i++) {
                int[] pair = pq.poll();
                pair[1]--;
                if(pair[1] > 0) tmp.add(pair);
                sb.append((char)('a' + pair[0]));
            }
            if(cnt < k && !tmp.isEmpty()) return "";
            for(int[] pair: tmp) {
                pq.offer(pair);
            }
        }

        return sb.toString();
    }
}
