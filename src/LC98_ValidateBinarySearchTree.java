public class LC98_ValidateBinarySearchTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        boolean isValidLeft = isValidBST(root.left);
        boolean isValidRight = isValidBST(root.right);
        if(isValidLeft && isValidRight){
            boolean l;
            boolean r;
            TreeNode cur = root.left;
            int max;
            if(cur==null) l = true;
            else{
                while(cur.right!=null) cur = cur.right;
                max = cur.val;
                l = max<root.val;
            }
            cur = root.right;
            int min;
            if(cur==null) r = true;
            else{
                while(cur.left!=null) cur = cur.left;
                min = cur.val;
                r = min>root.val;
            }
            return l && r;
        }else{
            return false;
        }
    }
}
