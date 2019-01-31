public class LC98_ValidateBinarySearchTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer low, Integer high){
        if(root==null) return true;

        if((low==null || root.val>low) && (high==null || root.val<high)){
            return isValidBST(root.left, (Integer)low, root.val) && isValidBST(root.right, root.val, (Integer)high);
        }
        else return false;
    }
}
