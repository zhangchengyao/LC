public class LC707_DesignLinkedList {
    class Node {
        int val;
        Node next;
        Node(int _val) {
            val = _val;
        }
    }

    private Node head;
    private int size;

    /** Initialize your data structure here. */
    public LC707_DesignLinkedList() {
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;

        Node cur = head;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null) {
            head = new Node(val);
            return;
        }

        Node cur = head;
        while(cur.next != null) cur = cur.next;
        cur.next = new Node(val);
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;

        if(index <= 0) {
            addAtHead(val);
        } else if(index == size) {
            addAtTail(val);
        } else {
            Node cur = head;
            for(int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            Node n = new Node(val);
            n.next = cur.next;
            cur.next = n;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;

        if(index == 0) {
            head = head.next;
        } else {
            Node cur = head;
            for(int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }

        size--;
    }
}
