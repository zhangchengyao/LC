import java.util.HashMap;
import java.util.HashSet;

public class LC403_FrogJump {
    HashMap<String, Boolean> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    public boolean canCross(int[] stones) {
        if(stones==null||stones.length<=1) return true;
        if(stones[1]!=1) return false;
        for(int stone: stones) set.add(stone);
        return check(stones[stones.length-1], 1, 1);
    }
    private boolean check(int lastStone, int pos, int k){
        if(pos==lastStone) return true;
        if(pos>lastStone || k==0 || !set.contains(pos)) return false;
        String str = pos+" "+k;
        if(map.containsKey(str)) return map.get(str);
        boolean res = false;
        res = check(lastStone, pos+k-1, k-1) || check(lastStone, pos+k, k) || check(lastStone, pos+k+1, k+1);
        map.put(str, res);
        return res;
    }
}
