import java.util.LinkedList;

public class LC104_MaximumDepthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int height = 0;
        int num = 1;
        while(!q.isEmpty()){
            for(int i=0;i<num;i++){
                TreeNode node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            num = q.size();
            height++;
        }
        return height;
    }
}
