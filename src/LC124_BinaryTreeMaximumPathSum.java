public class LC124_BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int best = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return best;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        int better = Math.max(root.val, Math.max(leftSum, rightSum) + root.val);
        best = Math.max(best, Math.max(better, leftSum + rightSum + root.val));

        return better;
    }
}
