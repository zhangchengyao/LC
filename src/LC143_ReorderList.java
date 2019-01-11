public class LC143_ReorderList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return ;

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode cur1 = head;
        ListNode after1 = cur1.next;
        ListNode cur2 = reverse(slow);
        ListNode after2 = cur2.next;
        while(cur1!=null && cur2!=null){
            cur1.next = cur2;
            if(after1!=null) cur2.next = after1;
            cur1 = after1;
            cur2 = after2;
            if(after1!=null) after1 = after1.next;
            if(after2!=null) after2 = after2.next;
        }

    }

    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode cur = head.next;
        ListNode after = head.next.next;
        head.next = null;

        while(true){
            cur.next = head;
            head = cur;
            cur = after;
            if(cur==null) break;
            after = after.next;
        }

        return head;
    }
}
