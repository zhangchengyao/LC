import java.util.Stack;

public class LC404_SumOfLeftLeaves {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        // if(root.left==null && root.right==null) return root.val;
        int sum = 0;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        boolean leftChild = false;
        int ctn = 0;
        while(true){
            ctn = 0;
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
                ctn++;
                if(ctn>1) leftChild = true;
            }
            if(stack.isEmpty()) break;
            cur = stack.pop();
            if(cur.right==null && leftChild) sum += cur.val;
            cur = cur.right;
            leftChild = false;
        }
        return sum;
    }
}
