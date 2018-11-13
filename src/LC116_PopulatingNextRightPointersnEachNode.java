public class LC116_PopulatingNextRightPointersnEachNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if(root==null || root.left==null) return;
        TreeLinkNode cur = root;
        while(cur.next!=null){
            cur.left.next = cur.right;
            cur.right.next = cur.next.left;
            cur = cur.next;
        }
        cur.left.next = cur.right;
        connect(root.left);
    }
}
