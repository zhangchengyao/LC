public class LC156_BinaryTreeUpsideDown {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

//    public TreeNode upsideDownBinaryTree(TreeNode root) {
//        if(root == null) return root;
//        TreeNode cur = root;
//        while(cur.left != null){
//            cur = cur.left;
//        }
//        return flip(cur, root);
//    }
//
//    private TreeNode flip(TreeNode cur, TreeNode root) {
//        if(cur == root || cur == null) return cur;
//
//        TreeNode parent = root;
//        while(parent.left != cur) parent = parent.left;
//        cur.left = parent.right;
//        parent.right = null;
//        parent.left = null;
//        cur.right = flip(parent, root);
//        return cur;
//    }
}
