public class LC105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRec(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode buildTreeRec(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2){
        if(s1>e1 || s2>e2) return null;
        TreeNode root = new TreeNode(preorder[s1]);
        int i = s2;
        while(inorder[i]!=preorder[s1]) i++;
        int left = i-s2; // left tree's length
        int right = e2-i; // right tree's length
        root.left = buildTreeRec(preorder, s1+1, s1+left, inorder, s2, i-1);
        root.right = buildTreeRec(preorder, s1+left+1, e1, inorder, i+1, e2);
        return root;
    }
}
