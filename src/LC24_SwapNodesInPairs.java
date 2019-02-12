public class LC24_SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode nextHead = swapPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = nextHead;
        return newHead;
    }
}
