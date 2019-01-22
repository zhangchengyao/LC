import java.util.LinkedList;
import java.util.Queue;

public class LC513_FindBottomLeftTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return -1;

        TreeNode res = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int cnt = q.size();
            for(int i=0;i<cnt;i++){
                TreeNode cur = q.poll();
                if(i==0) res = cur;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
        }

        return res.val;
    }
}
