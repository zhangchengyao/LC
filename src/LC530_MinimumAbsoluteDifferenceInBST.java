import java.util.Stack;

public class LC530_MinimumAbsoluteDifferenceInBST {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean first = true;
        int prev = 0;
        while(true){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()) break;
            cur = stack.pop();
            if(first){
                first = false;
                prev = cur.val;
            }
            else{
                min = Math.min(min, cur.val-prev);
                prev = cur.val;
            }
            cur = cur.right;
        }
        return min;
    }
}
