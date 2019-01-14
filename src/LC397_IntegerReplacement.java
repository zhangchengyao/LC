import java.util.HashMap;

public class LC397_IntegerReplacement {
    public int integerReplacement(int n) {
        return minReplacement(n, new HashMap<>());
    }

    private int minReplacement(long n, HashMap<Long, Integer> memo){
        if(n==1) return 0;
        if(memo.containsKey(n)) return memo.get(n);

        if( (n&1)==1 ){
            int min = Math.min(minReplacement(n+1, memo), minReplacement(n-1, memo));
            memo.put(n, min+1);
        } else {
            memo.put(n, minReplacement(n/2, memo)+1);
        }
        return memo.get(n);
    }
}
