public class LC138_CopyListWithRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;

        RandomListNode cur = head;
        while(cur!=null){
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }

        cur = head;
        while(cur!=null){
            if(cur.random!=null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        RandomListNode newHead = head.next;
        cur = head;
        RandomListNode cur2 = newHead;
        while(cur2!=null && cur2.next!=null){
            cur.next = cur.next.next;
            cur2.next = cur2.next.next;
            cur = cur.next;
            cur2 = cur2.next;
        }
        cur.next = null;
        return newHead;
    }
}
