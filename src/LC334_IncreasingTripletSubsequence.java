public class LC334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++) min[i] = Math.min(min[i-1], nums[i]);
        for(int i=nums.length-2;i>=0;i--) max[i] = Math.max(max[i+1], nums[i]);
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>min[i-1]&&nums[i]<max[i+1]) return true;
        }
        return false;
    }
    // genius solution
//    public boolean increasingTriplet(int[] nums) {
//        int n = Integer.MAX_VALUE;
//        int m = Integer.MAX_VALUE;
//        for(int i=0;i<nums.length;i++){
//            if(n>=nums[i]) n = nums[i];
//            else if(m>=nums[i]) m = nums[i];
//            else return true;
//        }
//        return false;
//    }
}
