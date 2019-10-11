import java.util.HashSet;
import java.util.Set;

public class LC888_FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        Set<Integer> nums = new HashSet<>();

        for(int a: A) sumA += a;
        for(int b: B) {
            sumB += b;
            nums.add(b);
        }

        int diff = (sumA - sumB) / 2;
        int[] res = new int[2];
        for(int a: A) {
            if(nums.contains(a - diff)) {
                res[0] = a;
                res[1] = a - diff;
                break;
            }
        }

        return res;
    }
}
