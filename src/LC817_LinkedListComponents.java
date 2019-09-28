import java.util.HashSet;
import java.util.Set;

public class LC817_LinkedListComponents {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> values = new HashSet<>();
        for(int val: G) values.add(val);

        int cnt = 0;
        ListNode cur = head;
        while(!values.isEmpty()) {
            while(!values.contains(cur.val)) cur = cur.next;
            cnt++;
            while(cur != null && values.contains(cur.val)) {
                values.remove(cur.val);
                cur = cur.next;
            }
        }

        return cnt;
    }
}
