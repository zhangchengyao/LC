import java.util.ArrayList;
import java.util.LinkedList;

public class LC101_SymmetricTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    // recursive solution
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null) return true;
        else if(t1!=null && t2==null) return false;
        else if(t1==null && t2!=null) return false;
        else return (t1.val==t2.val) && helper(t1.right, t2.left) && helper(t1.left, t2.right);
    }
    // iterative solution
//    public boolean isSymmetric(TreeNode root) {
//        LinkedList<TreeNode> q = new LinkedList<>();
//        int num = 1;
//        q.offer(root);
//        TreeNode cur = root;
//        ArrayList<Integer> layer = new ArrayList<>();
//        while(!q.isEmpty()){
//            layer.clear();
//            for(int i=0;i<num;i++){
//                cur = q.poll();
//                if(cur==null) layer.add(null);
//                else{
//                    layer.add(cur.val);
//                    q.offer(cur.left);
//                    q.offer(cur.right);
//                }
//            }
//            int i = 0;
//            int j = layer.size()-1;
//            while(i<j){
//                if(layer.get(i)!=layer.get(j)) return false;
//                i++;
//                j--;
//            }
//            num = q.size();
//        }
//        return true;
//    }
}
