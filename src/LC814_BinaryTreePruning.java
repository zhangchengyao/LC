public class LC814_BinaryTreePruning {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;

        if(root.left == null && root.right == null) {
            if(root.val == 1) return root;
            else return null;
        }

        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);

        if(root.val != 1 && left == null && right == null) return null;

        root.left = left;
        root.right = right;

        return root;
    }
}
