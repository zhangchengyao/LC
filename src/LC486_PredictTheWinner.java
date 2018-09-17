public class LC486_PredictTheWinner {
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
