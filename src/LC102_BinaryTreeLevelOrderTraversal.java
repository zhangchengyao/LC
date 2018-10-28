import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC102_BinaryTreeLevelOrderTraversal {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
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
            res.add(new ArrayList<>(tmp));
            tmp.clear();
            num = q.size();
        }
        return res;
    }
}
