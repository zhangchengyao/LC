import java.util.Comparator;
import java.util.PriorityQueue;

public class LC23_MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // O(nklogk) using minheap
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length==0) return null;
//        ListNode res = null;
//        ListNode cur = null;
//        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.val));
//        for(ListNode node: lists){
//            if(node!=null) pq.offer(node);
//        }
//        while(!pq.isEmpty()){
//            if(res==null){
//                res = pq.poll();
//                cur = res;
//                if(cur.next!=null) pq.offer(cur.next);
//            }
//            else{
//                cur.next = pq.poll();
//                cur = cur.next;
//                if(cur.next!=null) pq.offer(cur.next);
//            }
//        }
//        return res;
//    }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        // divide and conquer
        int n = lists.length;
        while(n>1){
            int k = (n+1)/2;
            for(int i=0;i+k<n;i++){
                lists[i] = merge2Lists(lists[i], lists[i+k]);
            }
            n = k;
        }
//        for(int i=1;i<lists.length;i++){
//            lists[0] = merge2Lists(lists[0], lists[i]);
//        }
        return lists[0];
    }
    private ListNode merge2Lists(ListNode list1, ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode q = list2;
        if(list2.val<list1.val){
            q = list2.next;
            list2.next = list1;
            list1 = list2;
        }
        ListNode p = list1;
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
        return list1;
    }
}
