import java.util.HashMap;
import java.util.Map;

public class LC337_HouseRobberIII {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public int rob(TreeNode root) {
        int[] res = robRec(root);
        return Math.max(res[0], res[1]);
    }
    private int[] robRec(TreeNode root){
        // The first element is the max money obtained from the scenario where root is not robbed
        // The second element is the max money obtained from the scenario where root is robbed
        int[] res = new int[2];
        if(root==null) return res;

        int[] leftInfo = robRec(root.left);
        int[] rightInfo = robRec(root.right);

        res[0] = Math.max(leftInfo[0], leftInfo[1]) + Math.max(rightInfo[0], rightInfo[1]);
        res[1] = root.val + leftInfo[0] + rightInfo[0];
        return res;
    }
    // This is an example of dynamic programming
//    public int rob(TreeNode root) {
//        return rob(root, new HashMap<TreeNode, Integer>());
//    }
//    private int rob(TreeNode root, Map<TreeNode, Integer> map){
//        if(root==null) return 0;
//        if(map.containsKey(root)) return map.get(root);
//
//        int value = 0;
//        if(root.left!=null){
//            value += (rob(root.left.left, map) + rob(root.left.right, map));
//        }
//        if(root.right!=null){
//            value += (rob(root.right.left, map) + rob(root.right.right, map));
//        }
//        int maxMoney = Math.max(root.val+value, rob(root.left, map)+rob(root.right, map));
//        map.put(root, maxMoney);
//        return maxMoney;
//    }
}
