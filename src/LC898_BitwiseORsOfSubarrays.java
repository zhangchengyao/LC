import java.util.HashSet;
import java.util.Set;

public class LC898_BitwiseORsOfSubarrays {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();

        for(int a: A) {
            Set<Integer> next = new HashSet<>();
            for(int n: cur) {
                next.add(n | a);
            }
            next.add(a);
            cur = next;
            res.addAll(cur);
        }

        return res.size();
    }
}
