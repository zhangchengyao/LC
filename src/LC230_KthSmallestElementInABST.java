import java.util.HashMap;

public class LC230_KthSmallestElementInABST {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public int kthSmallest(TreeNode root, int k) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return find(root, k, map);
    }
    private int find(TreeNode root, int k, HashMap<TreeNode, Integer> map){
        int left = getWeight(root.left, map);
        if(left==k-1) return root.val;
        else if(left<k-1){
            return kthSmallest(root.right, k-left-1);
        }
        else{
            return kthSmallest(root.left, k);
        }
    }
    private int getWeight(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root==null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int res = 1+getWeight(root.left, map)+getWeight(root.right, map);
        map.put(root, res);
        return res;
    }
}
