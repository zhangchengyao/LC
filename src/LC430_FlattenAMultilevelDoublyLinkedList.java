public class LC430_FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if(head==null) return null;

        return flattenRec(head)[0];
    }

    private Node[] flattenRec(Node head){
        if(head==null) return null;

        Node tail = null;
        Node cur = head;
        while(cur!=null){
            if(cur.child!=null){
                Node[] child = flattenRec(cur.child);
                cur.child = null;

                Node childHead = child[0];
                Node childTail = child[1];
                childTail.next = cur.next;
                if(cur.next!=null) cur.next.prev = childTail;
                cur.next = childHead;
                childHead.prev = cur;
                cur = childTail;
            }
            tail = cur;
            cur = cur.next;
        }

        return new Node[]{head, tail};
    }
}
