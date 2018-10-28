public class LC21_MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode q = l2;
        if(l2.val<l1.val){
            q = l2.next;
            l2.next = l1;
            l1 = l2;
        }
        ListNode p = l1;
        while(p.next!=null && q!=null){
            if(q.val>p.next.val){
                p = p.next;
            }
            else{
                ListNode tmp = q;
                q = q.next;
                tmp.next = p.next;
                p.next = tmp;
            }
        }
        if(p.next==null){
            p.next = q;
        }
        return l1;
    }
}
