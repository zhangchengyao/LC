public class LC86_PartitionList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode big = dummy;
        ListNode small;
        while(true){
            while(big.next!=null && big.next.val<x) big = big.next;
            if(big.next==null) break;
            small = big.next;
            while(small.next!=null && small.next.val>=x) small = small.next;
            if(small.next==null) break;
            ListNode tmp = small.next.next;
            small.next.next = big.next;
            big.next = small.next;
            small.next = tmp;
        }
        return dummy.next;
    }
}
