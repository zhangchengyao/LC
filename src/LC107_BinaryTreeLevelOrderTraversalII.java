import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC107_BinaryTreeLevelOrderTraversalII {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Stack<List<Integer>> stack = new Stack<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        int num = 1;
        q.offer(root);
        List<Integer> tmp = new ArrayList<>();
        while(!q.isEmpty()){
            for(int i=0;i<num;i++){
                TreeNode cur = q.poll();
                tmp.add(cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            stack.push(new ArrayList<>(tmp));
            tmp.clear();
            num = q.size();
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
