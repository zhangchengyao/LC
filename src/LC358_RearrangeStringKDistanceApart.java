import java.util.*;

public class LC358_RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        if(k==0 || k==1) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(11, new Comparator<Map.Entry<Character, Integer>>(){
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b){
                return a.getValue().equals(b.getValue())?a.getKey()-b.getKey():b.getValue()-a.getValue();
            }
        });
        for(Map.Entry<Character, Integer> entry: map.entrySet()) pq.offer(entry);
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int cnt = 0;
            ArrayList<Map.Entry<Character, Integer>> tmp = new ArrayList<>();
            for(;cnt<k;cnt++){
                if(pq.isEmpty()){
                    if(!tmp.isEmpty()) return "";
                    else break;
                }
                Map.Entry<Character, Integer> entry = pq.poll();
                entry.setValue(entry.getValue()-1);
                if(entry.getValue()>0) tmp.add(entry);
                sb.append(entry.getKey());
            }
            for(Map.Entry<Character, Integer> entry: tmp) pq.offer(entry);
        }
        return sb.toString();
    }
}
