public class LC117_PopulatingNextRightPointersInEachNodeII {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if(root==null || (root.left==null&&root.right==null)) return;
        TreeLinkNode cur = root;
        TreeLinkNode child = null;
        while(cur!=null && cur.left==null && cur.right==null) cur = cur.next;
        if(cur==null) return;
        if(cur.left==null){
            child = cur.right;
        }
        else if(cur.right==null){
            child = cur.left;
        }
        else{
            cur.left.next = cur.right;
            child = cur.right;
        }
        root = cur.left==null?cur.right:cur.left;
        TreeLinkNode after = cur.next;
        TreeLinkNode afterChild = null;
        while(after!=null){
            if(after.left==null && after.right==null) after = after.next;
            else if(after.left==null){
                afterChild = after.right;
                child.next = afterChild;
                cur = after;
                after = cur.next;
                child = afterChild;
            }
            else if(after.right==null){
                afterChild = after.left;
                child.next = afterChild;
                cur = after;
                after = cur.next;
                child = afterChild;
            }
            else{
                afterChild = after.left;
                child.next = afterChild;
                cur = after;
                after = cur.next;
                cur.left.next = cur.right;
                child = cur.right;
            }
        }
        while(root!=null && root.left==null && root.right==null) root = root.next;
        connect(root);
    }
}
