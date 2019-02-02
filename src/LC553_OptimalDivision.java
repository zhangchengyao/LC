public class LC553_OptimalDivision {
    public String optimalDivision(int[] nums) {
        if(nums.length == 1) return String.valueOf(nums[0]);
        if(nums.length == 2) return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);

        StringBuilder res = new StringBuilder(String.valueOf(nums[0]));

        StringBuilder sb = new StringBuilder();
        sb.append("/(");
        for(int i = 1; i < nums.length; i++){
            sb.append(nums[i]).append("/");
        }

        sb.setCharAt(sb.length() - 1, ')');

        res.append(sb);
        return res.toString();
    }
}
