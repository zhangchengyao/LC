import java.util.*;

public class LC894_AllPossibleFullBinaryTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if(N % 2 == 0) return new ArrayList<>();

        if(memo.containsKey(N)) return memo.get(N);
        if(N == 1) return Collections.singletonList(new TreeNode(0));

        List<TreeNode> res = new ArrayList<>();
        for(int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);

            for(TreeNode lRoot: left) {
                for(TreeNode rRoot: right) {
                    TreeNode root = new TreeNode(0);
                    root.left = lRoot;
                    root.right = rRoot;
                    res.add(root);
                }
            }
        }

        memo.put(N, res);
        return res;
    }
}
