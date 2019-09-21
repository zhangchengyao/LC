public class LC725_SplitLinkedListInParts {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = getLen(root);

        int size = len / k;
        int remaining = len % k;

        ListNode cur = root;
        for(int i = 0; i < k; i++) {
            res[i] = cur;
            if(remaining > 0) {
                for(int t = 0; t <= size; t++) {
                    if(t == size) {
                        ListNode tmp = cur.next;
                        cur.next = null;
                        cur = tmp;
                    } else {
                        cur = cur.next;
                    }
                }
                remaining--;
            } else {
                for(int t = 0; t < size; t++) {
                    if(t == size - 1) {
                        ListNode tmp = cur.next;
                        cur.next = null;
                        cur = tmp;
                    } else {
                        cur = cur.next;
                    }
                }
            }
        }

        return res;
    }

    private int getLen(ListNode root) {
        int len = 0;
        ListNode cur = root;
        while(cur != null) {
            cur = cur.next;
            len++;
        }

        return len;
    }
}
