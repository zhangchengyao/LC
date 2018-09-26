import java.util.HashMap;

public class LC236_LowestCommonAncestorOfABinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<String, Boolean> map = new HashMap<>();
        TreeNode cur = root;
        while(true){
            if(cur.val==p.val || cur.val==q.val) break;
            if((find(cur.left, p.val, map)&&find(cur.right, q.val, map))
                    || (find(cur.right, p.val, map)&&find(cur.left, q.val, map))) break;
            if(find(cur.left, p.val, map)) cur = cur.left;
            else cur = cur.right;
        }
        return cur;
    }
    private boolean find(TreeNode root, int val, HashMap<String, Boolean> map){
        if(root==null) return false;
        if(root.val==val) return true;
        String key = root.val+" "+val;
        if(map.containsKey(key)) return map.get(key);
        boolean res = find(root.left, val, map) || find(root.right, val, map);
        map.put(key, res);
        return res;
    }
}
