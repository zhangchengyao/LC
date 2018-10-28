import java.util.HashMap;

public class LC846_HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if(n%W!=0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = hand[0];
        for(int num: hand){
            map.put(num, map.getOrDefault(num, 0)+1);
            min = Math.min(min, num);
        }
        for(int i=0;i<n/W;i++){
            while(!map.containsKey(min)) min++;
            int cur = min;
            for(int j=0;j<W;j++){
                if(!map.containsKey(cur+j)) return false;
                map.put(cur+j, map.get(cur+j)-1);
                if(map.get(cur+j)==0) map.remove(cur+j);
            }
        }
        return true;
    }
}
