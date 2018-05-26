public class LC152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int maxProd = Integer.MIN_VALUE;
        int currentProd = 0;
        for(int i=0;i<nums.length;i++){
            if(currentProd==0) currentProd = nums[i];
            else currentProd *= nums[i];
            maxProd = Math.max(maxProd, currentProd);
        }
        currentProd = 0;
        for(int i=nums.length-1;i>=0;i--){
            if(currentProd==0) currentProd = nums[i];
            else currentProd *= nums[i];
            maxProd = Math.max(maxProd, currentProd);
        }
        return maxProd;
    }
}
