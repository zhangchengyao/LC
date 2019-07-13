import java.util.Arrays;

public class LC259_3SumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);

        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int p = i + 1;
            int q = nums.length - 1;
            while(p < q) {
                if(nums[p] + nums[q] < target - nums[i]){
                    count += q - p;
                    p++;
                } else {
                    q--;
                }
            }
        }

        return count;
    }
}
