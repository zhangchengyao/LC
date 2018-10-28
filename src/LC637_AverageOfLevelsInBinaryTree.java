import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC637_AverageOfLevelsInBinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        int num = 1;
        q.offer(root);
        long total;
        while(!q.isEmpty()){
            total = 0;
            for(int i=0;i<num;i++){
                TreeNode cur = q.poll();
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
                total += cur.val;
            }
            res.add(((double)total)/num);
            num = q.size();
        }
        return res;
    }
}
