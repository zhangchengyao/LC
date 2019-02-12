import java.util.*;

public class LC314_BinaryTreeVerticalOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        HashMap<TreeNode, Integer> cols = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        cols.put(root, 0);

        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            int col = cols.get(cur);

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(cur.val);

            if(cur.left != null){
                q.offer(cur.left);
                cols.put(cur.left, col - 1);
            }
            if(cur.right != null){
                q.offer(cur.right);
                cols.put(cur.right, col + 1);
            }
        }

        for(int key: map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }
}
