import java.util.ArrayList;
import java.util.List;

public class LC113_PathSumII {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int curSum, int target, List<Integer> path, List<List<Integer>> res){
        if(root==null) return ;

        curSum += root.val;
        path.add(root.val);

        if(root.left==null && root.right==null){
            if(curSum == target) res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        dfs(root.left, curSum, target, path, res);
        dfs(root.right, curSum, target, path, res);

        path.remove(path.size()-1);
    }

}
