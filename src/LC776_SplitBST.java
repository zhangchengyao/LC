public class LC776_SplitBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if(root==null) return res;
        if(root.val<=V){
            TreeNode[] right = splitBST(root.right, V);
            res[1] = right[1];
            root.right = right[0];
            res[0] = root;
        }
        else{
            TreeNode[] left = splitBST(root.left, V);
            res[0] = left[0];
            root.left = left[1];
            res[1] = root;
        }
        return res;
    }
}
