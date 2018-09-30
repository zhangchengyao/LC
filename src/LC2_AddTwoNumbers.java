public class LC2_AddTwoNumbers {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode sum = new ListNode((l1.val+l2.val)%10);
        int carry = (l1.val+l2.val)/10;
        ListNode cur = sum;
        cur1 = cur1.next;
        cur2 = cur2.next;
        while(cur1!=null && cur2!=null){
            int t = cur1.val+cur2.val+carry;
            cur.next = new ListNode(t%10);
            carry = t/10;
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while(cur1!=null){
            int t = cur1.val+carry;
            cur.next = new ListNode(t%10);
            carry = t/10;
            cur = cur.next;
            cur1 = cur1.next;
        }
        while(cur2!=null){
            int t = cur2.val+carry;
            cur.next = new ListNode(t%10);
            carry = t/10;
            cur = cur.next;
            cur2 = cur2.next;
        }
        if(carry>0) cur.next = new ListNode(1);
        return sum;
    }
}
