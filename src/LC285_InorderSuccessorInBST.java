import java.util.Stack;

public class LC285_InorderSuccessorInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        TreeNode prev = null;
//        TreeNode cur = root;
//        boolean found = false;
//
//        while(cur != null) {
//            if(cur.left != null) {
//                prev = cur.left;
//                while(prev.right != null && prev.right != cur) prev = prev.right;
//                if(prev.right == null) {
//                    prev.right = cur;
//                    cur = cur.left;
//                } else {
//                    prev.right = null;
//                    if(found) return cur;
//                    if(cur == p) found = true;
//                    prev = cur;
//                    cur = cur.right;
//                }
//            } else {
//                if(found) return cur;
//                if(cur == p) found = true;
//                prev = cur;
//                cur = cur.right;
//            }
//        }
//
//        return null;
//    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur == p){
                return getSucc(cur, stack);
            } else if(cur.val < p.val){
                stack.push(cur);
                cur = cur.right;
            } else {
                stack.push(cur);
                cur = cur.left;
            }
        }

        return null;
    }

    private TreeNode getSucc(TreeNode root, Stack<TreeNode> stack){
        if(root.right == null){
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node.val > root.val){
                    return node;
                }
            }
            return null;
        } else {
            TreeNode cur = root.right;
            while(cur.left != null){
                cur = cur.left;
            }
            return cur;
        }
    }
}
