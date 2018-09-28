public class LC671_SecondMinimumNodeInABinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left==null) return -1;
        int min = root.val;
        int findLeft = root.left.val==min?findSecondMinimumValue(root.left):root.left.val;
        int findRight = root.right.val==min?findSecondMinimumValue(root.right):root.right.val;
        if(findLeft==-1) return findRight;
        if(findRight==-1) return findLeft;
        return Math.min(findLeft, findRight);
    }
}
