import java.util.LinkedList;
import java.util.Queue;

public class LC623_AddOneRowToTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        q.offer(root);
        while(level < d) {
            int cnt = q.size();
            for(int i = 0; i < cnt; i++) {
                TreeNode cur = q.poll();
                if(level == d - 1) {
                    TreeNode left = new TreeNode(v);
                    left.left = cur.left;
                    cur.left = left;
                    TreeNode right = new TreeNode(v);
                    right.right = cur.right;
                    cur.right = right;
                } else {
                    if(cur.left != null) q.offer(cur.left);
                    if(cur.right != null) q.offer(cur.right);
                }
            }
            level++;
        }

        return root;
    }
}
