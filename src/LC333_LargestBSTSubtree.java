public class LC333_LargestBSTSubtree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Result{
        TreeNode root;
        int min;
        int max;
        int num;
        Result(TreeNode _root, int _min, int _max, int _num){
            root = _root;
            min = _min;
            max = _max;
            num = _num;
        }
    }
    private Result best = null;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;

        helper(root);
        return best.num;
    }

    private Result helper(TreeNode root){
        if(root == null) return null;

        Result leftRes = helper(root.left);
        Result rightRes = helper(root.right);

        Result res = null;
        if(leftRes == null && rightRes == null){
            if(root.left == null && root.right == null){
                res = new Result(root, root.val, root.val, 1);
            }
        } else if(leftRes == null){
            if(root.left == null && root.val < rightRes.min){
                res = new Result(root, root.val, rightRes.max, rightRes.num + 1);
            }
        } else if(rightRes == null){
            if(root.right == null && root.val > leftRes.max){
                res = new Result(root, leftRes.min, root.val, leftRes.num + 1);
            }
        } else {
            if(root.val > leftRes.max && root.val < rightRes.min){
                res = new Result(root, leftRes.min, rightRes.max, leftRes.num + rightRes.num + 1);
            }
        }

        if(res != null && (best == null || res.num > best.num)){
            best = res;
        }

        return res;
    }
}
