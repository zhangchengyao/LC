public class LC250_CountUnivalueSubtrees {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Result {
        boolean isUnivalue;
        int count;

        Result(boolean isUnivalue, int count) {
            this.isUnivalue = isUnivalue;
            this.count = count;
        }
    }

    public int countUnivalSubtrees(TreeNode root) {
        return checkSubtree(root) != null ? checkSubtree(root).count : 0;
    }

    private Result checkSubtree(TreeNode root) {
        if(root == null) return null;

        Result resLeft = checkSubtree(root.left);
        Result resRight = checkSubtree(root.right);

        int count = 0;
        if(resLeft != null) {
            count += resLeft.count;
        }
        if(resRight != null) {
            count += resRight.count;
        }

        boolean isUnivalue = (resLeft == null || (resLeft.isUnivalue && root.val == root.left.val))
                && (resRight == null || (resRight.isUnivalue && root.val == root.right.val));

        if(isUnivalue) count++;

        return new Result(isUnivalue, count);
    }
}
