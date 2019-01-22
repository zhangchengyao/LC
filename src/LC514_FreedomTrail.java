import java.util.HashMap;

public class LC514_FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        return rotate(ring, key, 0, new HashMap<>());
    }

    private int rotate(String ring, String key, int next, HashMap<String, Integer> memo){
        if(next==key.length()) return 0;

        String state = ring + next;
        if(memo.containsKey(state)) return memo.get(state);

        char c = key.charAt(next);
        // anticlockwise
        int idx1 = ring.indexOf(c);
        int steps1 = idx1 + 1 + rotate(ring.substring(idx1)+ring.substring(0, idx1), key, next+1, memo);

        // clockwise
        int idx2 = ring.lastIndexOf(c);
        int steps2 = ring.length() - idx2 + 1 + rotate(ring.substring(idx2)+ring.substring(0, idx2), key, next+1, memo);

        memo.put(state, Math.min(steps1, steps2));
        return memo.get(state);
    }
}
