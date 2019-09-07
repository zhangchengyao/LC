public class LC1120_MaximumAverageSubtree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Result {
        int size;
        int sum;
        Result(int _size, int _sum) {
            size = _size;
            sum = _sum;
        }
    }

    private double maxAvg = 0;

    public double maximumAverageSubtree(TreeNode root) {
        helper(root);

        return maxAvg;
    }

    private Result helper(TreeNode root) {
        if(root == null) return new Result(0, 0);

        Result leftRes = helper(root.left);
        Result rightRes = helper(root.right);

        int sum = leftRes.sum + rightRes.sum + root.val;
        int size = leftRes.size + rightRes.size + 1;

        double avg = sum * 1.0 / size;
        maxAvg = Math.max(maxAvg, avg);

        return new Result(size, sum);
    }
}
