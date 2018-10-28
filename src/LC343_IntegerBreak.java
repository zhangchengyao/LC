import java.util.HashMap;

public class LC343_IntegerBreak {
    public int integerBreak(int n) {
        return breakRec(n, new HashMap<>(), 1);
    }
    private int breakRec(int n, HashMap<Integer, Integer> map, int num){
        if(n<=1) return 1;
        if(map.containsKey(n)) return map.get(n);
        int max = 0;
        for(int i=1;i<=n;i++){
            if(num==1 && i==n) break;
            max = Math.max(max, i*breakRec(n-i, map, i==n?num:num+1));
        }
        map.put(n, max);
        return max;
    }
}
