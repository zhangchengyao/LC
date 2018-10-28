import java.util.LinkedList;

public class LC111_MinimumDepthOfBinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        int height = 1;
        int num = 1;
        q.offer(root);
        while(!q.isEmpty()){
            for(int i=0;i<num;i++){
                TreeNode cur = q.poll();
                if(cur.left==null && cur.right==null) return height;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            height++;
            num = q.size();
        }
        return height;
    }
}
