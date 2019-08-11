public class LC708_InsertIntoACyclicSortedList {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if(head == null) {
            head = new Node();
            head.val = insertVal;
            head.next = head;
        } else if(head.next == head) {
            head.next = new Node(insertVal, head);
        } else {
            Node cur = head;
            if(cur.val == insertVal) {
                cur.next = new Node(insertVal, cur.next);
            } else if(cur.val > insertVal) {
                while(cur.val <= cur.next.val && cur.next != head) cur = cur.next;
                if(cur.next.val >= insertVal) {
                    cur.next = new Node(insertVal, cur.next);
                } else {
                    cur = cur.next;
                    while(cur.next.val < insertVal) cur = cur.next;
                    cur.next = new Node(insertVal, cur.next);
                }
            } else {
                while(cur.next.val < insertVal && cur.next.val >= cur.val && cur.next != head) cur = cur.next;
                cur.next = new Node(insertVal, cur.next);
            }
        }

        return head;
    }
}
