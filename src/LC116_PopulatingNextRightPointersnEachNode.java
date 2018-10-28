public class LC116_PopulatingNextRightPointersnEachNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if(root==null || root.left==null) return;
        root.left.next = root.right;
        TreeLinkNode cur = root;
        while(cur.next!=null){
            cur.right.next = cur.next.left;
            cur = cur.next;
        }
        connect(root.left);
        connect(root.right);
    }
}
