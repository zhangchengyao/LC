public class LC486_PredictTheWinner {
    // dynamic programming
//    public boolean PredictTheWinner(int[] nums) {
//        int[][] dp = new int[nums.length][nums.length];
//        for(int i=0;i<nums.length;i++) dp[i][i] = nums[i];
//        for(int len=1;len<nums.length;len++){
//            for(int i=0;i<nums.length-len;i++){
//                int j = i+len;
//                dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
//            }
//        }
//        return dp[0][nums.length-1]>=0;
//    }
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length==0) return true;
        return predictRec(nums, 0, nums.length-1, 0, 0, 1);
    }
    private boolean predictRec(int[] nums, int start, int end, int score1, int score2, int player){
        if(start==end){
            if(player==1) return score1+nums[start]>=score2;
            else return score1<score2+nums[start];
        }
        if(player==1) return !predictRec(nums, start+1, end, score1+nums[start], score2, 2) || !predictRec(nums, start, end-1, score1+nums[end], score2, 2);
        else return !predictRec(nums, start+1, end, score1, score2+nums[start], 1) || !predictRec(nums, start, end-1, score1, score2+nums[end], 1);
    }
}
