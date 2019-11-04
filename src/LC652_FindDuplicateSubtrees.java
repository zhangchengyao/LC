import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC652_FindDuplicateSubtrees {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        preOrder(map, root, res);
        return res;
    }

    private String preOrder(Map<String, Integer> map, TreeNode root, List<TreeNode> res){
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(" ");
        sb.append(preOrder(map, root.left, res));
        sb.append(preOrder(map, root.right, res));
        String s = sb.toString();
        if(map.containsKey(s) && map.get(s) == 1) res.add(root);
        map.put(s, map.getOrDefault(s, 0) + 1);
        return sb.toString();
    }
}
