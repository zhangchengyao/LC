import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199_BinaryTreeRightSideView {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int cnt = q.size();
            for(int i=0;i<cnt;i++){
                TreeNode cur = q.poll();
                if(i==0) res.add(cur.val);
                if(cur.right!=null) q.offer(cur.right);
                if(cur.left!=null) q.offer(cur.left);
            }
        }

        return res;
    }
}
