import java.util.HashSet;
import java.util.Iterator;

public class LC421_MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=31;i>=0;i--){
            set.clear();
            mask |= (1<<i);
            for(int j=0;j<nums.length;j++){
                set.add(mask&nums[j]);
            }
            int t = max|(1<<i);
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                if(set.contains(it.next()^t)){
                    max = t;
                    break;
                }
            }
        }
        return max;
    }
}
