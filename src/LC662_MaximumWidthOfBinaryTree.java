import java.util.LinkedList;
import java.util.Queue;

public class LC662_MaximumWidthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        int res = 1;

        q.offer(root);
        root.val = 1;
        int cnt = 0;
        while(!q.isEmpty()){
            cnt = q.size();
            int left = 0;
            int right = 0;
            for(int i=0;i<cnt;i++){
                TreeNode cur = q.poll();
                if(i==0) left = cur.val;
                if(i==cnt-1) right = cur.val;
                if(cur.left!=null){
                    q.offer(cur.left);
                    cur.left.val = 2*cur.val;
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                    cur.right.val = 2*cur.val+1;
                }
            }
            if(right-left+1>res) res = right-left+1;
        }
        return res;
    }
}
