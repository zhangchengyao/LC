public class LC543_DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        findDeepest(root);
        return res;
    }
    private int findDeepest(TreeNode root){
        if(root==null || (root.left==null&&root.right==null)) return 0;
        int left = findDeepest(root.left);
        int right = findDeepest(root.right);
        int len = left+right;
        if(root.left!=null) len++;
        if(root.right!=null) len++;
        if(len>res) res = len;
        return Math.max(left, right)+1;
    }
}
