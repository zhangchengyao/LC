public class LC687_LongestUnivaluePath {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int longest = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return longest;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(root.left != null && root.val == root.left.val) left++;
        else left = 0;

        if(root.right != null && root.val == root.right.val) right++;
        else right = 0;

        longest = Math.max(longest, left + right);

        return Math.max(left, right);
    }

    // solution without instance variable
//    public int longestUnivaluePath(TreeNode root) {
//        if(root==null) return 0;
//
//        int withoutRoot = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
//        int withRoot = dfs(root.left, root.val) + dfs(root.right, root.val);
//
//        return Math.max(withRoot, withoutRoot);
//    }
//
//    private int dfs(TreeNode root, int rootVal){
//        if(root==null || root.val!=rootVal) return 0;
//
//        return 1 + Math.max(dfs(root.left, rootVal), dfs(root.right, rootVal));
//    }
}
