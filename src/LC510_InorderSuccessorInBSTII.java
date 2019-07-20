public class LC510_InorderSuccessorInBSTII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node x) {
        Node cur;
        if(x.right != null) {
            cur = x.right;
            while(cur.left != null) cur = cur.left;
        } else {
            cur = x.parent;
            while(cur != null && cur.val < x.val) cur = cur.parent;
        }
        return cur;
    }
}
