public class LC445_AddTwoNumbersII {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode sum = new ListNode((cur1.val+cur2.val)%10);
        int carry = (cur1.val+cur2.val)/10;
        cur1 = cur1.next;
        cur2 = cur2.next;
        ListNode cur = sum;
        while(cur1!=null && cur2!=null){
            int t = cur1.val+cur2.val+carry;
            cur.next = new ListNode(t%10);
            carry = t/10;
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur = cur.next;
        }
        while(cur1!=null){
            int t = cur1.val+carry;
            cur.next = new ListNode(t%10);
            carry = t/10;
            cur1 = cur1.next;
            cur = cur.next;
        }
        while(cur2!=null){
            int t = cur2.val+carry;
            cur.next = new ListNode(t%10);
            carry = t/10;
            cur2 = cur2.next;
            cur = cur.next;
        }
        if(carry>0) cur.next = new ListNode(1);
        return reverse(sum);
    }
    private ListNode reverse(ListNode head){
        if(head==null) return null;
        ListNode prev = head;
        ListNode cur = prev.next;
        while(cur!=null){
            head.next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = head.next;
        }
        return prev;
    }
}
