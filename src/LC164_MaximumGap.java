import java.util.Arrays;

public class LC164_MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;

        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if(max==min) return 0;

        double bucketSize = (max-min)*1.0/(n-1);
        int bucketNum = (int)((max-min)/bucketSize) + 1;

        int[] mins = new int[bucketNum];
        int[] maxs = new int[bucketNum];
        Arrays.fill(mins, Integer.MAX_VALUE);
        Arrays.fill(maxs, Integer.MIN_VALUE);
        for(int num: nums){
            int offset = (int)((num-min) / bucketSize);
            mins[offset] = Math.min(mins[offset], num);
            maxs[offset] = Math.max(maxs[offset], num);
        }

        int maxDiff = Integer.MIN_VALUE;
        int prevMax = maxs[0];
        for(int i=1;i<mins.length;i++){
            if(mins[i]!=Integer.MAX_VALUE){
                maxDiff = Math.max(maxDiff, mins[i]-prevMax);
                prevMax = maxs[i];
            }
        }

        return maxDiff;
    }
}
