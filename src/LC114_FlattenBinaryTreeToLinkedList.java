public class LC114_FlattenBinaryTreeToLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return;
        if(root.left==null){
            flatten(root.right);
            return ;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode cur = root.left;
        while(cur.right!=null) cur = cur.right;
        cur.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
