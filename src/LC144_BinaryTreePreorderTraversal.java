import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144_BinaryTreePreorderTraversal {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null){
            res.add(cur.val);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
            if(stack.isEmpty()) break;
            cur = stack.pop();
        }
        return res;
    }
}
