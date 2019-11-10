public class LC698_PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % k != 0) return false;
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return partitionRec(nums, k, target, 0, 0, visited);
    }
    private boolean partitionRec(int[] nums, int k, int target, int start, int curSum, boolean[] visited) {
        if(k == 1) return true;
        if(curSum > target) return false;
        if(curSum == target) return partitionRec(nums, k - 1, target, 0, 0, visited);
        for(int i = start; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                boolean res = partitionRec(nums, k, target, i + 1, curSum + nums[i], visited);
                if(!res) visited[i] = false;
                else return true;
            }
        }
        return false;
    }
}
