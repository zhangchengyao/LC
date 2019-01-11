public class LC142_LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }

        if(fast==null || fast.next==null) return null;

        slow = head;
        while(fast!=slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
