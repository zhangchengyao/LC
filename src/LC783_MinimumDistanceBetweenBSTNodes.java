public class LC783_MinimumDistanceBetweenBSTNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;

        TreeNode prev;
        TreeNode before = null;
        TreeNode cur = root;

        while(cur != null){
            if(cur.left == null){
                if(before != null){
                    min = Math.min(min, cur.val - before.val);
                }
                before = cur;

                cur = cur.right;
            } else {
                prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    if(before != null){
                        min = Math.min(min, cur.val - before.val);
                    }
                    before = cur;

                    cur = cur.right;
                }
            }
        }

        return min;
    }
}
