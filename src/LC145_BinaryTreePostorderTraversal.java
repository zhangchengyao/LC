import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145_BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        TreeNode cur = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while(!stack.isEmpty()){
            cur = stack.peek();
            if(cur.left==null && cur.right==null || (prev!=null && (prev==cur.left || prev==cur.right))){
                res.add(cur.val);
                stack.pop();
                prev = cur;
            }
            else{
                if(cur.right!=null) stack.push(cur.right);
                if(cur.left!=null) stack.push(cur.left);
            }
        }
        return res;
    }
}
