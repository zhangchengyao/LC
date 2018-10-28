import java.util.HashMap;

public class LC765_CouplesHoldingHands {
    // greedy algorithm, but why works?
    public int minSwapsCouples(int[] row) {
        HashMap<Integer, Integer> map = new HashMap<>(); // label => index
        for(int i=0;i<row.length;i++) map.put(row[i], i);
        int res = 0;
        for(int i=0;i<row.length;i+=2){
            if((row[i]&1)==1){
                int index = map.get(row[i]-1);
                if(index!=i+1){
                    res++;
                    row[index] = row[i+1];
                    map.put(row[i+1], index);
                }
            }else{
                int index = map.get(row[i]+1);
                if(index!=i+1){
                    res++;
                    row[index] = row[i+1];
                    map.put(row[i+1], index);
                }
            }
        }
        return res;
    }
}
