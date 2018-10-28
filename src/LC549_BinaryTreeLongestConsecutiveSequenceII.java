public class LC549_BinaryTreeLongestConsecutiveSequenceII {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    int max = Integer.MIN_VALUE;
    public int longestConsecutive2(TreeNode root) {
        find(root);
        return max;

    }
    private int[] find(TreeNode root){
        if(root==null) return null;
        int[] l = find(root.left);
        int[] r = find(root.right);
        int asc = 1;
        int desc = 1;
        if(l!=null){
            if(root.val-root.left.val==-1) asc = Math.max(asc, l[0]+1);
            if(root.val-root.left.val==1) desc = Math.max(desc, l[1]+1);
        }
        if(r!=null){
            if(root.val-root.right.val==-1) asc = Math.max(asc, r[0]+1);
            if(root.val-root.right.val==1) desc = Math.max(desc, r[1]+1);
        }
        max = Math.max(max, asc+desc-1);
        return new int[]{asc, desc};
    }
}
