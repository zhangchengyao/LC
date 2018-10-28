import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94_BinaryTreeInorderTraversal {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    // Morris traversal
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        TreeNode cur = root;
//        TreeNode prev = null;
//        while(cur!=null){
//            if(cur.left==null){
//                res.add(cur.val);
//                cur = cur.right;
//            }
//            else{
//                prev = cur.left;
//                while(prev.right!=null && prev.right!=cur) prev = prev.right;
//                if(prev.right==null){
//                    prev.right = cur;
//                    cur = cur.left;
//                }
//                else{
//                    prev.right = null;
//                    res.add(cur.val);
//                    cur = cur.right;
//                }
//            }
//        }
//        return res;
//    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()) break;
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
