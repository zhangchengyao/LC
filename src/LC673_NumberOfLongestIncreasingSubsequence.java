import java.util.Arrays;

public class LC673_NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length < 1) return 0;

        int[] length = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        int longest = 0;

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(length[i] == length[j] + 1) {
                        count[i] += count[j];
                    } else if(length[i] < length[j] + 1) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if(length[i] > length[longest]) longest = i;
        }

        int res = 0;
        for(int i = 0; i < length.length; i++) {
            if(length[i] == length[longest]) res += count[i];
        }

        return res;
    }
}
