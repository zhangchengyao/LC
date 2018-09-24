import java.util.LinkedList;

public class LC226_InvertBinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int num = 1;
        while(!q.isEmpty()){
            for(int i=0;i<num;i++){
                TreeNode cur = q.poll();
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
            }
            num = q.size();
        }
        return root;
    }
}
