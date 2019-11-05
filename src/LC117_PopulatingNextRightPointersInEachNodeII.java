public class LC117_PopulatingNextRightPointersInEachNodeII {
    public class Node {
        int val;
        Node left, right, next;
        Node(int x) { val = x; }
    }

    public Node connect(Node root) {
        Node cur = root;
        while(cur != null && cur.left == null && cur.right == null) cur = cur.next;
        if(cur == null) return root;

        Node head = cur.left == null ? cur.right : cur.left;

        Node after = cur.next;
        while(true) {
            while(after != null && after.left == null && after.right == null) after = after.next;
            if(after == null) break;

            if(cur.left != null && cur.right != null) {
                cur.left.next = cur.right;
                cur.right.next = after.left == null ? after.right : after.left;
            } else if(cur.right == null) {
                cur.left.next = after.left == null ? after.right : after.left;
            } else {
                cur.right.next = after.left == null ? after.right : after.left;
            }
            cur = after;
            after = after.next;
        }
        if(cur.left != null && cur.right != null) cur.left.next = cur.right;

        connect(head);

        return root;
    }
}
