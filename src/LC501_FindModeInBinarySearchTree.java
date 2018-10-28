import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC501_FindModeInBinarySearchTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    int max = 0;
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        inOrder(root, map);
        List<Integer> res = new ArrayList<>();
        for(Integer key: map.keySet()){
            if(map.get(key)==max) res.add(key);
        }
        int[] resArr = new int[res.size()];
        for(int i=0;i<res.size();i++)
            resArr[i] = res.get(i);
        return resArr;
    }
    private void inOrder(TreeNode root, HashMap<Integer, Integer> map){
        if(root==null) return;
        inOrder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        if(max<map.get(root.val)) max = map.get(root.val);
        inOrder(root.right, map);
    }
}
