public class LC270_ClosestBinarySearchTreeValue {
    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
        }
    }
    public int closestValue(TreeNode root, double target) {
        if(target==root.val) return root.val;
        else if(target>root.val){
            if(root.right==null) return root.val;
            double d1 = target-root.val;
            int rightVal = closestValue(root.right, target);
            double d2 = Math.abs(target-rightVal);
            return d1<d2?root.val:rightVal;
        }else{
            if(root.left==null) return root.val;
            double d1 = root.val-target;
            int leftVal = closestValue(root.left, target);
            double d2 = Math.abs(target-leftVal);
            return d1<d2?root.val:leftVal;
        }
    }
}
