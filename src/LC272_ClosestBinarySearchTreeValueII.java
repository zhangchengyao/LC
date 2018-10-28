import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC272_ClosestBinarySearchTreeValueII {
    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    // O(logn) solution using two stacks
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> small = new Stack<>();
        Stack<TreeNode> big = new Stack<>();
        TreeNode cur = root;
        while(cur!=null){
            if(cur.val<=target){
                small.push(cur);
                cur = cur.right;
            }else{
                big.push(cur);
                cur = cur.left;
            }
        }
        for(int i=0;i<k;i++){
            if(big.isEmpty() || (!small.isEmpty()&&target-small.peek().val<=big.peek().val-target)){
                TreeNode node = small.pop();
                res.add(node.val);
                getPred(node, small);
            }else{
                TreeNode node = big.pop();
                res.add(node.val);
                getSucc(node, big);
            }
        }
        return res;
    }
    private void getPred(TreeNode root, Stack<TreeNode> s){
        if(root.left!=null){
            TreeNode cur = root.left;
            while(cur!=null){
                s.push(cur);
                cur = cur.right;
            }
        }
    }
    private void getSucc(TreeNode root, Stack<TreeNode> s){
        if(root.right!=null){
            TreeNode cur = root.right;
            while(cur!=null){
                s.push(cur);
                cur = cur.left;
            }
        }
    }

    // O(n) solution (in-order traversal)
//    public List<Integer> closestKValues(TreeNode root, double target, int k) {
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> s = new Stack<>();
//        TreeNode cur = root;
//        while(true){
//            while(cur!=null){
//                s.push(cur);
//                cur = cur.left;
//            }
//            if(s.isEmpty()) break;
//            cur = s.pop();
//            if(res.size()<k) res.add(cur.val);
//            else{
//                if(target<=res.get(0)) break;
//                else{
//                    if(Math.abs(target-cur.val)<target-res.get(0)){
//                        res.remove(0);
//                        res.add(cur.val);
//                    }
//                }
//            }
//            cur = cur.right;
//        }
//        return res;
//    }
}
