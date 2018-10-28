import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC95_UniqueBinarySearchTreesII {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    HashMap<String, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        if(n<1) return new ArrayList<>();
        return generate(1, n);
    }
    private List<TreeNode> generate(int l ,int r){
        List<TreeNode> res = new ArrayList<>();
        if(l>r){
            res.add(null);
            return res;
        }
        String str = l+" "+r;
        if(map.containsKey(str)) return map.get(str);
        for(int i=l;i<=r;i++){
            List<TreeNode> left = generate(l, i-1);
            List<TreeNode> right = generate(i+1, r);
            for(TreeNode nodeL: left){
                for(TreeNode nodeR: right){
                    TreeNode root = new TreeNode(i);
                    root.left = nodeL;
                    root.right = nodeR;
                    res.add(root);
                }
            }
        }
        map.put(str, res);
        return res;
    }
}
