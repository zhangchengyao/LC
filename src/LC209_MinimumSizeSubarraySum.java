public class LC209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(s>sum) return 0;
        int i = 0;
        int j = -1;
        int length = 0;
        sum = 0;
        int min = Integer.MAX_VALUE;
        while(j<nums.length-1){
            if(sum<s){
                length++;
                sum += nums[++j];
            }else{
                i++;
                length--;
                sum -= nums[i-1];
            }
            if(sum>=s && length<min) min = length;
            if(i>j) return 1;
        }
        while(sum>=s){
            i++;
            length--;
            sum -= nums[i-1];
        }
        return Math.min(min, length+1);
    }
}
