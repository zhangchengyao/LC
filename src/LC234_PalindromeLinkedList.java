public class LC234_PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next !=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        if(fast != null) slow = slow.next;

        fast = reverse(head);

        while(slow != null && fast !=null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode cur = head.next;
        ListNode after = cur.next;
        head.next = null;

        while(cur != null){
            cur.next = head;
            head = cur;
            cur = after;
            if(after != null) after = after.next;
        }

        return head;
    }
}
