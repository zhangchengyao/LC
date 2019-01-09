public class LC112_PathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode root, int curSum, int target){
        if(root==null) return false;

        curSum += root.val;

        if(root.left==null && root.right==null){
            return curSum == target;
        }

        return dfs(root.left, curSum, target) || dfs(root.right, curSum, target);
    }
}
