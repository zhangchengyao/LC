public class LC235_LowestCommonAncestorOfABinarySearchTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(true){
            if((p.val-cur.val)*(q.val-cur.val)<=0) break;
            else if(p.val<cur.val) cur = cur.left;
            else cur = cur.right;
        }
        return cur;
    }
}
