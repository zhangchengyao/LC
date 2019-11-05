import java.util.HashMap;
import java.util.Map;

public class LC663_EqualTreePartition {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Map<TreeNode, Integer> treeSum = new HashMap<>();

    public boolean checkEqualTree(TreeNode root) {
        dfs(root);

        int totalSum = treeSum.get(root);
        if(totalSum % 2 != 0) return false;

        for(TreeNode node: treeSum.keySet()) {
            if(node == root) continue;
            if(treeSum.get(node) * 2 == totalSum) return true;
        }

        return false;
    }

    private void dfs(TreeNode root) {
        if(root == null) return ;

        dfs(root.left);
        dfs(root.right);

        int sum = root.val;
        if(root.left != null) sum += treeSum.get(root.left);
        if(root.right != null) sum += treeSum.get(root.right);

        treeSum.put(root, sum);
    }
}
