public class LC106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeRec(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode buildTreeRec(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2){
        if(s1>e1 || s2>e2) return null;
        TreeNode root = new TreeNode(postorder[e2]);
        int i = 0;
        while(inorder[i]!=postorder[e2]) i++;
        int left = i-s1; // the length of left subtree
        int right = e1-i; // the length of right subtree
        root.left = buildTreeRec(inorder, s1, i-1, postorder, s2, s2+left-1);
        root.right = buildTreeRec(inorder, i+1, e1, postorder, s2+left, e2-1);
        return root;
    }
}
