public class LC42_TrappingRainWater {
    public int trap(int[] height) {
        if(height==null || height.length<3) return 0;
        int res = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            int h = Math.min(height[left], height[right]);
            if(height[left]<=height[right]){
                left++;
                while(height[left]<h){
                    res += h-height[left];
                    left++;
                }
            }else{
                right--;
                while(height[right]<h){
                    res += h-height[right];
                    right--;
                }
            }
        }
        return res;
    }
}
