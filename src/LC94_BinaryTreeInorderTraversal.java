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
