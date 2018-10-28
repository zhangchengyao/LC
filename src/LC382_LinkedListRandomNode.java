public class LC382_LinkedListRandomNode {
    // when the length of the list is unknown, use reservoir sampling
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LC382_LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = head.val;
        int i = 2;
        ListNode cur = head.next;
        while(cur!=null){
            int index = (int)(Math.random()*i);
            if(index==0) res = cur.val;
            cur = cur.next;
            i++;
        }
        return res;
    }
}
