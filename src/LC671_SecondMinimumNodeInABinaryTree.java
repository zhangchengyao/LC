public class LC671_SecondMinimumNodeInABinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left == null) return -1;

        int min = root.val;
        int leftRes = root.left.val == min ? findSecondMinimumValue(root.left) : root.left.val;
        int rightRes = root.right.val == min ? findSecondMinimumValue(root.right) : root.right.val;
        if(leftRes == -1) return rightRes;
        if(rightRes == -1) return leftRes;

        return Math.min(leftRes, rightRes);
    }
}
