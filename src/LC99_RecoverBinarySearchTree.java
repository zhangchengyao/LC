import java.util.Stack;

public class LC99_RecoverBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // O(1) space complexity
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        while(cur!=null){
            if(cur.left==null){
                if(second==null){
                    if(first!=null && first.val>cur.val){
                        second = cur;
                    }
                    else first = cur;
                }
                else{
                    if(second.val>cur.val) second = cur;
                }
                cur = cur.right;
            }
            else{
                prev = cur.left;
                while(prev.right!=null && prev.right!=cur) prev = prev.right;
                if(prev.right==null){
                    prev.right = cur;
                    cur = cur.left;
                }
                else{
                    prev.right = null;
                    if(second==null){
                        if(first!=null && first.val>cur.val){
                            second = cur;
                        }
                        else first = cur;
                    }
                    else{
                        if(second.val>cur.val) second = cur;
                    }
                    cur = cur.right;
                }
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
//    public void recoverTree(TreeNode root) {
//        TreeNode first = null;
//        TreeNode second = null;
//        boolean find = false;
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        while(true){
//            while(cur!=null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//            if(stack.isEmpty()) break;
//            cur = stack.pop();
//            if(find){
//                if(cur.val<second.val){
//                    second = cur;
//                    break;
//                }
//            }
//            else{
//                if(first==null || first.val<cur.val) first = cur;
//                else{
//                    find = true;
//                    second = cur;
//                }
//            }
//            cur = cur.right;
//        }
//        int tmp = first.val;
//        first.val = second.val;
//        second.val = tmp;
//    }
}