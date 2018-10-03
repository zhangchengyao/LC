public class LC450_DeleteNodeInABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode parent = cur;
        boolean isLeft = true;
        while(cur!=null && cur.val!=key){
            parent = cur;
            if(cur.val<key){
                cur = cur.right;
                isLeft = false;
            }
            else{
                cur = cur.left;
                isLeft = true;
            }
        }
        if(cur==null) return root;
        if(cur.left==null && cur.right==null){
            if(parent==cur) return null;
            if(isLeft) parent.left = null;
            else parent.right = null;
        }else if(cur.left==null){
            if(parent==cur) return cur.right;
            if(isLeft) parent.left = cur.right;
            else parent.right = cur.right;
        }else if(cur.right==null){
            if(parent==cur) return cur.left;
            if(isLeft) parent.left = cur.left;
            else parent.right = cur.left;
        }else{
            TreeNode q = cur.left;
            TreeNode p = cur;
            while(q.right!=null){
                p = q;
                q = q.right;
            }
            cur.val = q.val;
            if(p==cur){
                p.left = q.left;
            }
            else{
                p.right = q.left;
            }
        }
        return root;
    }
}
