public class LC776_SplitBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];

        if(root == null) return res;

        if(root.val <= V) {
            res[0] = root;
            TreeNode[] rightRes = splitBST(root.right, V);
            root.right = rightRes[0];
            res[1] = rightRes[1];
        } else {
            res[1] = root;
            TreeNode[] leftRes = splitBST(root.left, V);
            root.left = leftRes[1];
            res[0] = leftRes[0];
        }

        return res;
    }
}
