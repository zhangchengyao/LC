import java.util.Stack;

public class LC173_BinarySearchTreeIterator {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    Stack<TreeNode> stack;
    public LC173_BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(stack.isEmpty()) return 0;
        TreeNode cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        return res;
    }
}
