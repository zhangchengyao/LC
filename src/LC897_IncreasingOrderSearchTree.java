public class LC897_IncreasingOrderSearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode newRoot = null;
    private TreeNode cur = null;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);

        return newRoot;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        if(newRoot == null) {
            newRoot = new TreeNode(root.val);
            cur = newRoot;
        } else {
            cur.right = new TreeNode(root.val);
            cur = cur.right;
        }
        inorder(root.right);
    }
}
