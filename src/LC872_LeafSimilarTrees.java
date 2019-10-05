import java.util.Stack;

public class LC872_LeafSimilarTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<Integer> stack = new Stack<>();
        dfs1(root1, stack);

        return dfs2(root2, stack) && stack.isEmpty();
    }

    private void dfs1(TreeNode root, Stack<Integer> stack) {
        if(root == null) return ;
        if(root.left == null && root.right == null) {
            stack.push(root.val);
            return ;
        }

        dfs1(root.left, stack);
        dfs1(root.right, stack);
    }

    private boolean dfs2(TreeNode root, Stack<Integer> stack) {
        if(root.left == null && root.right == null) {
            if(stack.isEmpty()) return false;
            int val = stack.pop();
            return val == root.val;
        }

        if(root.right != null) {
            if(!dfs2(root.right, stack)) return false;
        }
        if(root.left != null) {
            return dfs2(root.left, stack);
        }

        return true;
    }
}
