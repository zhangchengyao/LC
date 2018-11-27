import java.util.*;

public class LC752_OpenTheLock {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        Set<String> visited = new HashSet<>();
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>();
        if(set.contains("0000")) return -1;
        visited.add("0000");
        q.offer("0000");
        int cnt;
        int layer = 0;
        while(!q.isEmpty()){
            cnt = q.size();
            for(int k=0;k<cnt;k++){
                char[] cur = q.poll().toCharArray();
                if(target.equals(String.valueOf(cur))) return layer;
                for(int i=0;i<4;i++){
                    char c = cur[i];
                    cur[i] = (char)((c-'0'+1)%10+'0');
                    String str = String.valueOf(cur);
                    if(!set.contains(str) && !visited.contains(str)){
                        q.offer(str);
                        visited.add(str);
                    }
                    cur[i] = (char)((c-'0'+9)%10+'0');
                    str = String.valueOf(cur);
                    if(!set.contains(str) && !visited.contains(str)){
                        q.offer(str);
                        visited.add(str);
                    }
                    cur[i] = c;
                }
            }
            layer++;
        }
        return -1;
    }
}
