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
        while(true){
            while(cur!=null){
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            while(!stack.isEmpty()){
                cur = stack.pop();
                if(cur.right!=null) break;
            }
            if(cur!=null && cur.right!=null) cur = cur.right;
            else break;
        }
        return res;
    }
}
