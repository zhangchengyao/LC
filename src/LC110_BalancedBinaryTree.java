public class LC110_BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    boolean imbalance = false;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        calculateHeight(root);
        return !imbalance;
    }
    private int calculateHeight(TreeNode root){
        if(imbalance) return -1;
        if(root==null) return 0;
        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);
        if(Math.abs(left-right)>1) imbalance = true;
        return Math.max(left, right)+1;
    }
}
