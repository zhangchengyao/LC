import java.util.HashSet;
import java.util.Set;

public class LC653_TwoSumIV_InputIsABST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean findTarget(TreeNode root, int k) {
        return inorder(root, k, new HashSet<>());
    }

    private boolean inorder(TreeNode root, int k, Set<Integer> numbers) {
        if(root == null) return false;
        if(inorder(root.left, k, numbers)) return true;
        if(numbers.contains(k - root.val)) return true;
        numbers.add(root.val);
        return inorder(root.right, k, numbers);
    }
}
