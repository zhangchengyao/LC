public class LC865_SmallestSubtreeWithAllTheDeepestNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(leftHeight == rightHeight) return root;
        else if(leftHeight > rightHeight) return subtreeWithAllDeepest(root.left);
        else return subtreeWithAllDeepest(root.right);
    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
