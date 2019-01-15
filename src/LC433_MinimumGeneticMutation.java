import java.util.*;

public class LC433_MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        HashMap<String, List<String>> graph = new HashMap<>();
        for(int i=0;i<bank.length;i++){
            for(int j=i+1;j<bank.length;j++){
                if(canMutate(bank[i], bank[j])){
                    graph.putIfAbsent(bank[i], new ArrayList<>());
                    graph.get(bank[i]).add(bank[j]);
                    graph.putIfAbsent(bank[j], new ArrayList<>());
                    graph.get(bank[j]).add(bank[i]);
                }
            }
        }
        if(!graph.containsKey(start)){
            for(String seq: bank){
                if(canMutate(start, seq)){
                    graph.putIfAbsent(start, new ArrayList<>());
                    graph.get(start).add(seq);
                }
            }
        }

        int numMutation = 0;
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);
        while(!q.isEmpty()){
            int cnt = q.size();
            for(int i=0;i<cnt;i++){
                String cur = q.poll();
                if(cur.equals(end)) return numMutation;
                if(graph.get(cur)==null) continue;
                for(String neighbor: graph.get(cur)){
                    if(!visited.contains(neighbor)){
                        visited.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
            numMutation++;
        }

        return -1;
    }

    private boolean canMutate(String a, String b){
        int diff = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
                if(diff>1) return false;
            }
        }
        return diff == 1;
    }
}
