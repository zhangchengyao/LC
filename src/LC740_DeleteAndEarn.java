public class LC740_DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[] count = new int[10001];
        int kinds = 0;
        for(int num: nums) {
            count[num]++;
            if(count[num] == 1) kinds++;
        }

        int[] dp = new int[kinds + 1];
        int prev = -2;
        int cur = 0;
        for(int i = 1; i <= kinds; i++) {
            while(count[cur] == 0) cur++;
            if(prev + 1 == cur) {
                dp[i] = Math.max(cur * count[cur] + dp[i - 2], dp[i - 1]);
            } else {
                dp[i] = dp[i - 1] + cur * count[cur];
            }
            prev = cur;
            cur++;
        }

        return dp[kinds];
    }
}
