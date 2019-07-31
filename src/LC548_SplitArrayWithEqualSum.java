import java.util.HashSet;

public class LC548_SplitArrayWithEqualSum {
    public boolean splitArray(int[] nums) {
        if(nums.length < 7) return false;

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        for(int j = 3; j < nums.length - 3; j++) {
            HashSet<Integer> leftSum = new HashSet<>();
            for(int i = j - 2; i > 0; i--) {
                if(sums[i - 1] == sums[j - 1] - sums[i]) leftSum.add(sums[i - 1]);
            }
            for(int k = j + 2; k < nums.length - 1; k++) {
                int half = sums[k - 1] - sums[j];
                if(half == sums[nums.length - 1] - sums[k] && leftSum.contains(half)) return true;
            }
        }

        return false;
    }
}
