import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC368_LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==0) return res;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] before = new int[nums.length];
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                        before[i] = j;
                    }
                }
            }
        }
        int max = 0;
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]>max){
                max = dp[i];
                index = i;
            }
        }
        for(int i=0;i<max;i++){
            res.add(nums[index]);
            index = before[index];
        }
        return res;
    }
}
