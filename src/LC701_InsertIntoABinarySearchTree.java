public class LC701_InsertIntoABinarySearchTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode cur = root;
        while(true){
            if(cur.val<val){
                if(cur.right==null){
                    cur.right = new TreeNode(val);
                    break;
                }
                else cur = cur.right;
            }else{
                if(cur.left==null){
                    cur.left = new TreeNode(val);
                    break;
                }
                else cur = cur.left;
            }
        }
        return root;
    }
}
