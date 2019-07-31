public class LC549_BinaryTreeLongestConsecutiveSequenceII {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    class Result {
        int inc;
        int desc;

        Result(int _inc, int _desc) {
            inc = _inc;
            desc = _desc;
        }
    }

    private int longest = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return longest;
    }

    private Result helper(TreeNode root) {
        if(root == null) return null;

        Result left = helper(root.left);
        Result right = helper(root.right);
        int inc = 1;
        int desc = 1;
        if(left != null) {
            if(root.val == root.left.val + 1) desc += left.desc;
            else if(root.val == root.left.val - 1) inc += left.inc;
        }
        if(right != null) {
            if(root.val == root.right.val + 1) desc = Math.max(desc, 1 + right.desc);
            else if(root.val == root.right.val - 1) inc = Math.max(inc, 1 + right.inc);
        }

        longest = Math.max(longest, inc + desc - 1);
        return new Result(inc, desc);
    }
}
