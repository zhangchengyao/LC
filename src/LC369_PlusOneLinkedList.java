public class LC369_PlusOneLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        ListNode cur = head;
        int carry = 1;
        while(cur.next != null){
            cur.val += carry;
            if(cur.val == 10){
                cur.val = 0;
                cur = cur.next;
            }
            else{
                carry = 0;
                break;
            }
        }
        if(carry == 1){
            cur.val += carry;
            if(cur.val == 10){
                cur.val = 0;
                cur.next = new ListNode(1);
            }
        }
        return reverse(head);
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode before = head;
        ListNode cur = head.next;
        ListNode after = cur.next;
        while(cur != null){
            cur.next = before;
            head.next = after;
            if(after == null) break;
            before = cur;
            cur = after;
            after = after.next;
        }
        head = cur;
        return head;
    }

    // recursive solution
//    public ListNode plusOne(ListNode head) {
//        if(head == null) return null;
//
//        int carry = plus(head.next);
//        if(carry == 1) {
//            head.val++;
//            if(head.val == 10) {
//                head.val = 0;
//                ListNode newHead = new ListNode(1);
//                newHead.next = head;
//                head = newHead;
//            }
//        }
//        return head;
//    }
//
//    private int plus(ListNode head) {
//        if(head == null) return 1;
//
//        int carry = plus(head.next);
//        if(carry == 1) {
//            head.val++;
//            if(head.val == 10) {
//                head.val = 0;
//                return 1;
//            }
//        }
//
//        return 0;
//    }
}
