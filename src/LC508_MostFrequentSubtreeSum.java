import java.util.HashMap;
import java.util.HashSet;

public class LC508_MostFrequentSubtreeSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private HashMap<Integer, Integer> count = new HashMap<>();
    private HashSet<Integer> sums = new HashSet<>();
    private int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        subtreeSum(root);

        int[] res = new int[sums.size()];
        int i = 0;
        for(int sum: sums){
            res[i++] = sum;
        }

        return res;
    }

    private int subtreeSum(TreeNode root){
        if(root==null) return 0;

        int sum = root.val + subtreeSum(root.left) + subtreeSum(root.right);
        count.put(sum, count.getOrDefault(sum, 0)+1);
        if(count.get(sum)>maxFreq){
            sums.clear();
            sums.add(sum);
            maxFreq = count.get(sum);
        } else if(count.get(sum)==maxFreq){
            sums.add(sum);
        }

        return sum;
    }
}
