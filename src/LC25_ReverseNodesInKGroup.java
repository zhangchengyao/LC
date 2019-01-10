public class LC25_ReverseNodesInKGroup {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return head;

        ListNode start = head;
        ListNode end = moveForward(head, k-1);
        if(end==null) return head;

        ListNode before = head;
        ListNode after = end.next;

        while(true){
            end.next = null;
            ListNode[] res = reverse(start);

            if(res[1]==head) head = res[0];
            else before.next = res[0];

            res[1].next = after;

            before = res[1];
            start = after;
            end = moveForward(start, k-1);
            if(end==null) break;
            after = end.next;
        }

        return head;
    }

    private ListNode moveForward(ListNode head, int k){
        if(head==null) return null;

        ListNode cur = head;
        for(int i=0;i<k;i++){
            cur = cur.next;
            if(cur==null) break;
        }
        return cur;
    }

    private ListNode[] reverse(ListNode head){
        if(head==null || head.next==null) return new ListNode[]{head, head};

        ListNode before = head;
        ListNode cur = head.next;
        ListNode after = head.next.next;

        while(true){
            cur.next = before;
            before = cur;
            cur = after;
            if(cur==null) break;
            after = after.next;
        }

        head.next = null;
        return new ListNode[]{before, head};
    }
}
