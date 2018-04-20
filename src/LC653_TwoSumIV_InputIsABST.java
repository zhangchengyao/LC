import java.util.ArrayList;
import java.util.List;

public class LC653_TwoSumIV_InputIsABST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<>();
        return preOrder(root, k, lst);
    }
    private boolean preOrder(TreeNode root, int k, List<Integer> lst){
        if(root==null) return false;
        if(lst.contains(k-root.val)) return true;
        else{
            lst.add(root.val);
            return preOrder(root.left, k, lst) || preOrder(root.right, k, lst);
        }
    }
}
