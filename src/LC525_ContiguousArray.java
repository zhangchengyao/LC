import java.util.HashMap;

public class LC525_ContiguousArray {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) count++;
            else count--;

            if(map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxLen;
    }

//    public int findMaxLength(int[] nums) {
//        int n = nums.length;
//
//        int[] numZeros = new int[n + 1];
//        int[] numOnes = new int[n + 1];
//
//        for(int i = 0; i < n; i++) {
//            if(nums[i] == 0) {
//                numZeros[i + 1] = numZeros[i] + 1;
//                numOnes[i + 1] = numOnes[i];
//            } else {
//                numZeros[i + 1] = numZeros[i];
//                numOnes[i + 1] = numOnes[i] + 1;
//            }
//        }
//
//        for(int len = (n & 1) == 1 ? n - 1 : n; len > 1; len -= 2) {
//            for(int i = 0; i <= n - len; i++) {
//                int ones = numOnes[i + len] - numOnes[i];
//                int zeros = numZeros[i + len] - numZeros[i];
//                if(ones == zeros) return len;
//            }
//        }
//
//        return 0;
//    }
}
