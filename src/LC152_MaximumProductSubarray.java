public class LC152_MaximumProductSubarray {
    // dynamic programming
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]));
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<dpMax.length;i++){
            if(dpMax[i]>max) max = dpMax[i];
        }
        return max;
        // key point: the subarray that has max product must start from the first non 0 element either side
        // if(nums.length==1) return nums[0];
        // int maxProd = Integer.MIN_VALUE;
        // int currentProd = 0;
        // for(int i=0;i<nums.length;i++){
        //     if(currentProd==0) currentProd = nums[i];
        //     else currentProd *= nums[i];
        //     maxProd = Math.max(maxProd, currentProd);
        // }
        // currentProd = 0;
        // for(int i=nums.length-1;i>=0;i--){
        //     if(currentProd==0) currentProd = nums[i];
        //     else currentProd *= nums[i];
        //     maxProd = Math.max(maxProd, currentProd);
        // }
        // return maxProd;
    }
}
