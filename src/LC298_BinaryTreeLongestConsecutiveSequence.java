public class LC298_BinaryTreeLongestConsecutiveSequence {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    int max = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        find(root, null, 0);
        return max;
    }
    private void find(TreeNode root, TreeNode parent, int cur){
        if(parent==null || root.val-parent.val!=1) cur = 1;
        else cur++;
        max = Math.max(cur, max);
        if(root.left!=null) find(root.left, root, cur);
        if(root.right!=null) find(root.right, root, cur);
    }
}
