import java.util.LinkedList;
import java.util.Queue;

public class LC649_Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        int[] parties = new int[2];
        int[] bans = new int[2];
        for(char p: senate.toCharArray()) {
            q.offer(p);
            int x = p == 'R' ? 0 : 1;
            parties[x]++;
        }

        while(!q.isEmpty() && parties[0] > 0 && parties[1] > 0) {
            char p = q.poll();
            int x = p == 'R' ? 0 : 1;
            if(bans[x ^ 1] > 0) {
                parties[x]--;
                bans[x ^ 1]--;
            } else {
                q.offer(p);
                bans[x]++;
            }
        }

        return parties[0] > 0 ? "Radiant" : "Dire";
    }
}
