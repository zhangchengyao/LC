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
        boolean res = check(lastStone, pos+k-1, k-1) || check(lastStone, pos+k, k) || check(lastStone, pos+k+1, k+1);
        map.put(str, res);
        return res;
    }
    // another solution
//    public boolean canCross(int[] stones) {
//        if(stones==null||stones.length<=1) return true;
//        if(stones[1]!=1) return false;
//        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
//        for(int i: stones) map.put(i, new HashSet<>());
//        map.get(1).add(1);
//        for(int i=1;i<stones.length-1;i++){
//            for(int jump: map.get(stones[i])){
//                if(jump>1 && map.containsKey(stones[i]+jump-1)) map.get(stones[i]+jump-1).add(jump-1);
//                if(map.containsKey(stones[i]+jump)) map.get(stones[i]+jump).add(jump);
//                if(map.containsKey(stones[i]+jump+1)) map.get(stones[i]+jump+1).add(jump+1);
//            }
//        }
//        return !map.get(stones[stones.length-1]).isEmpty();
//    }
}
