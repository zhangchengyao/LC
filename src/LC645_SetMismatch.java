public class LC645_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1) {
                if(nums[nums[i] - 1] == nums[i]) break;

                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                res[0] = nums[i];
                res[1] = i + 1;
                break;
            }
        }

        return res;
    }
}
