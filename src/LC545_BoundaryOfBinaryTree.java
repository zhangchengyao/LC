import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC545_BoundaryOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        res.add(root.val);
        if(root.left == null && root.right == null) return res;

        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);

        return res;
    }

    private void addLeftBoundary(TreeNode root, List<Integer> res){
        if(root == null || (root.left == null && root.right == null)) return ;

        res.add(root.val);
        if(root.left != null) addLeftBoundary(root.left, res);
        else addLeftBoundary(root.right, res);
    }

    private void addLeaves(TreeNode root, List<Integer> res){
        if(root == null) return;

        if(root.left == null && root.right == null){
            res.add(root.val);
            return ;
        }
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    private void addRightBoundary(TreeNode root, List<Integer> res){
        if(root == null || (root.left == null && root.right == null)) return ;

        if(root.right != null) addRightBoundary(root.right, res);
        else addRightBoundary(root.left, res);
        res.add(root.val);
    }

    // iterative solution
//    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//
//        if(root == null) return res;
//
//        res.add(root.val);
//        if(root.left == null && root.right == null) return res;
//
//        addLeftBoundary(root, res);
//        addLeaves(root, res);
//        addRightBoundary(root, res);
//
//        return res;
//    }
//
//    private void addLeftBoundary(TreeNode root, List<Integer> res){
//        if(root == null || root.left == null) return ;
//
//        TreeNode cur = root.left;
//        while(cur.left != null || cur.right != null){
//            res.add(cur.val);
//            if(cur.left != null){
//                cur = cur.left;
//            } else {
//                cur = cur.right;
//            }
//        }
//    }
//
//    private void addLeaves(TreeNode root, List<Integer> res){
//        if(root == null) return;
//
//        if(root.left == null && root.right == null){
//            res.add(root.val);
//            return ;
//        }
//        addLeaves(root.left, res);
//        addLeaves(root.right, res);
//    }
//
//    private void addRightBoundary(TreeNode root, List<Integer> res){
//        if(root == null || root.right == null) return;
//
//        Stack<Integer> stack = new Stack<>();
//        TreeNode cur = root.right;
//        while(cur.left != null || cur.right != null){
//            stack.push(cur.val);
//            if(cur.right != null){
//                cur = cur.right;
//            } else {
//                cur = cur.left;
//            }
//        }
//
//        while(stack.size() > 0){
//            res.add(stack.pop());
//        }
//    }
}
