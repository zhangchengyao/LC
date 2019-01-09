import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC103_BinaryTreeZigzagLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;

        LinkedList<TreeNode> list = new LinkedList<>();
        boolean leftToRight = true;
        list.add(root);
        while(!list.isEmpty()){
            int cnt = list.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<cnt;i++){
                if(leftToRight){
                    TreeNode cur = list.removeFirst();
                    level.add(cur.val);
                    if(cur.left!=null) list.addLast(cur.left);
                    if(cur.right!=null) list.addLast(cur.right);
                } else {
                    TreeNode cur = list.removeLast();
                    level.add(cur.val);
                    if(cur.right!=null) list.addFirst(cur.right);
                    if(cur.left!=null) list.addFirst(cur.left);
                }
            }
            leftToRight = !leftToRight;
            res.add(level);
        }

        return res;
    }
}
