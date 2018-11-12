public class LC572_SubtreeOfAnotherTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null && s==null) return true;
        if(t==null || s==null) return false;
        if(helper(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean helper(TreeNode s, TreeNode t){
        if(s==null && t==null) return true;
        if(t==null || s==null) return false;
        return s.val==t.val && helper(s.left, t.left) && helper(s.right, t.right);
    }
}
