public class LC487_MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int left = 0;
        int right = 0;
        boolean first0 = true;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(first0) left++;
                else right++;
            } else {
                if(first0) {
                    first0 = false;
                } else {
                    if(nums[i - 1] == 0) {
                        left = 0;
                    } else {
                        res = Math.max(res, left + right + 1);
                        left = right;
                    }
                    right = 0;
                }
            }
        }

        return Math.max(res, left + right + (first0 ? 0 : 1));
    }
}
