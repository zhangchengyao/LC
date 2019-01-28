package amazon;

public class Maximum_Average_Node {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    static class Result{
        TreeNode root;
        int sum;
        int size;

        Result(TreeNode _root, int _sum, int _size){
            root = _root;
            sum = _sum;
            size = _size;
        }
    }

    private static Result best = null;

    public static TreeNode subtreeMaxAvgNode(TreeNode root){
        if(root==null) return null;

        maxAvgSubtree(root);
        return best.root;
    }

    private static Result maxAvgSubtree(TreeNode root){
        if(root==null) return new Result(null, 0, 0);
        if(root.left==null && root.right==null) return new Result(root, root.val, 1);

        Result left = maxAvgSubtree(root.left);
        Result right = maxAvgSubtree(root.right);

        Result cur = new Result(root, left.sum+right.sum+root.val, left.size+right.size+1);

        if(best==null || cur.sum*1.0/cur.size > best.sum*1.0/best.size) best = cur;

        return cur;
    }
}
