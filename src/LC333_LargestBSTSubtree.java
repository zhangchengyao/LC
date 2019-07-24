public class LC333_LargestBSTSubtree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Result{
        boolean isBST;
        int size;
        int maxVal;
        int minVal;
        Result(boolean isBST, int size, int maxVal, int minVal) {
            this.isBST = isBST;
            this.size = size;
            this.maxVal = maxVal;
            this.minVal = minVal;
        }
    }

    private int largest = 0;

    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        checkBST(root);
        return largest;
    }

    private Result checkBST(TreeNode root) {
        Result left = null;
        Result right = null;
        if(root.left != null) {
            left = checkBST(root.left);
        }
        if(root.right != null) {
            right = checkBST(root.right);
        }

        int min = root.val;
        int max = root.val;
        if(left != null) {
            min = Math.min(left.minVal, min);
            max = Math.max(left.maxVal, max);
        }
        if(right != null) {
            min = Math.min(right.minVal, min);
            max = Math.max(right.maxVal, max);
        }

        if((left == null || (left.isBST && left.maxVal < root.val)) &&
                (right ==null || (right.isBST && right.minVal > root.val))) {
            int size = (left == null ? 0 : left.size) + (right == null ? 0 : right.size) + 1;
            if(size > largest) largest = size;
            return new Result(true, size, max, min);
        } else {
            return new Result(false, -1, max, min);
        }
    }
}
