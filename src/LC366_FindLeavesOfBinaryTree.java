import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC366_FindLeavesOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int maxHeight = 0;

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        HashMap<TreeNode, Integer> map = new HashMap<>();
        getHeight(root, map);

        for(int i = 0; i <= maxHeight; i++) {
            res.add(new ArrayList<>());
        }

        preorder(root, map, res);

        return res;
    }

    private int getHeight(TreeNode root, HashMap<TreeNode, Integer> map) {
        if(root.left == null && root.right == null) {
            map.put(root, 0);
            return 0;
        }

        int height = 0;
        if(root.left != null) height = Math.max(height, getHeight(root.left, map) + 1);
        if(root.right != null) height= Math.max(height, getHeight(root.right, map) + 1);

        map.put(root, height);
        maxHeight = Math.max(maxHeight, height);
        return height;
    }

    private void preorder(TreeNode root, HashMap<TreeNode, Integer> map, List<List<Integer>> res) {
        if(root == null) return ;
        res.get(map.get(root)).add(root.val);
        preorder(root.left, map, res);
        preorder(root.right, map, res);
    }
}
