import java.util.*;

public class LC582_KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < pid.size(); i++){
            int key = ppid.get(i);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(pid.get(i));
        }

        Queue<Integer> toKill = new LinkedList<>();
        toKill.offer(kill);
        List<Integer> res = new ArrayList<>();
        while(!toKill.isEmpty()){
            int cur = toKill.poll();
            res.add(cur);

            if(map.get(cur) == null) continue;

            for(int child: map.get(cur)){
                toKill.offer(child);
            }
        }

        return res;
    }
}
