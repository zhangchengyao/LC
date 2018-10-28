import java.util.ArrayList;
import java.util.List;

public class LC257_BinaryTreePaths {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, new StringBuilder());
        return res;
    }
    private void dfs(TreeNode root, List<String> res, StringBuilder tmp){
        if(root==null) return;
        tmp.append(root.val);
        if(root.left==null && root.right==null){
            res.add(tmp.toString());
            return;
        }
        tmp.append("->");
        dfs(root.left, res, new StringBuilder(tmp));
        dfs(root.right, res, new StringBuilder(tmp));
    }
}
