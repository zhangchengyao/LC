public class LC53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = nums[0];
        for(int i=1;i<nums.length;i++){
            if(cur+nums[i]>nums[i]){
                cur += nums[i];
            }
            else cur = nums[i];
            if(cur>max) max = cur;
        }
        return max;
    }
    // divide and conquer
//    public int maxSubArray(int[] nums) {
//        return findSub(nums, 0, nums.length-1);
//    }
//    private int findSub(int[] nums, int l, int r){
//        if(l==r){
//            return nums[l];
//        }
//        int mid = l + (r-l)/2;
//        int left = findSub(nums, l, mid);
//        int right = findSub(nums, mid+1, r);
//        int max = Math.max(left, right);
//        int cur = nums[mid];
//        int tmp = nums[mid];
//        for(int i=mid-1;i>=l;i--){
//            tmp += nums[i];
//            if(tmp>cur) cur = tmp;
//        }
//        tmp = cur;
//        for(int i=mid+1;i<=r;i++){
//            tmp += nums[i];
//            if(tmp>cur) cur = tmp;
//        }
//        if(cur>max) max = cur;
//        return max;
//    }
}
