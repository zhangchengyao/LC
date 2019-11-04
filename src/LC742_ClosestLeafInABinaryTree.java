import java.util.HashMap;
import java.util.Map;

public class LC742_ClosestLeafInABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class SearchRes {
        int leafVal;
        int dist;
        SearchRes(int _leafVal, int _dist) {
            leafVal = _leafVal;
            dist = _dist;
        }
    }

    private int closest = Integer.MAX_VALUE;
    private int val = 0;

    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, Integer> distMap = new HashMap<>();

        searchTarget(root, k, distMap);
        closestLeaf(root, distMap);

        return val;
    }

    private int searchTarget(TreeNode root, int k, Map<TreeNode, Integer> distMap) {
        if(root == null) return -1;
        if(root.val == k) {
            distMap.put(root, 0);
            return 0;
        }

        int left = searchTarget(root.left, k, distMap);
        int right = searchTarget(root.right, k, distMap);

        if(left == -1 && right == -1) return -1;

        distMap.put(root, left >= 0 ? left + 1 : right + 1);

        return distMap.get(root);
    }

    private SearchRes closestLeaf(TreeNode root, Map<TreeNode, Integer> distMap) {
        if(root == null) return new SearchRes(-1, Integer.MAX_VALUE);
        if(root.left == null && root.right == null) {
            SearchRes res = new SearchRes(root.val, 0);
            if(distMap.get(root) != null && distMap.get(root) < closest) {
                closest = distMap.get(root);
                val = root.val;
            }
            return res;
        }

        SearchRes left = closestLeaf(root.left, distMap);
        SearchRes right = closestLeaf(root.right, distMap);
        SearchRes res = new SearchRes(left.dist < right.dist ? left.leafVal : right.leafVal, left.dist < right.dist ? left.dist + 1 : right.dist + 1);
        if(distMap.get(root) != null && distMap.get(root) + res.dist < closest) {
            closest = distMap.get(root) + res.dist;
            val = res.leafVal;
        }
        return res;
    }
}
