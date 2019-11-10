public class LC700_SearchInABinarySearchTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        TreeNode cur = root;
        while(true) {
            if(cur.val == val) return cur;
            else if(cur.val > val) {
                if(cur.left == null) break;
                else cur = cur.left;
            }
            else {
                if(cur.right == null) break;
                else cur = cur.right;
            }
        }
        return null;
    }
}
