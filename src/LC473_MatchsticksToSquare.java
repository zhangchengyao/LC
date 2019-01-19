import java.util.Arrays;

public class LC473_MatchsticksToSquare {
    public boolean makesquare(int[] nums) {
        if(nums==null || nums.length<4) return false;

        int sum = getSum(nums);
        if(sum%4!=0) return false;
        int length = sum / 4;

        Arrays.sort(nums);

        int[] sides = new int[4];
        return makeSquare(nums, nums.length-1, length, sides);
    }

    private boolean makeSquare(int[] nums, int start, int target, int[] sides){
        if(start<0) return sides[0]==target && sides[1]==target && sides[2]==target;

        int matchstick = nums[start];
        for(int i=0;i<sides.length;i++){
            if(sides[i]==target || sides[i]+matchstick>target) continue;

            sides[i] += matchstick;
            boolean res = makeSquare(nums, start-1, target, sides);
            if(res) return true;
            sides[i] -= matchstick;
        }

        return false;
    }

    private int getSum(int[] nums){
        int sum = 0;
        for(int num: nums) sum += num;
        return sum;
    }
}
