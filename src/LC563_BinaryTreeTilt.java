public class LC563_BinaryTreeTilt {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int sum = 0;

    public int findTilt(TreeNode root) {
        getSum(root);
        return sum;
    }

    private int getSum(TreeNode root){
        if(root == null) return 0;

        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);

        int tilt = Math.abs(leftSum - rightSum);
        sum += tilt;

        return root.val + leftSum + rightSum;
    }
}
