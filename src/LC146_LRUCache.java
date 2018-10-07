import java.util.HashMap;

public class LC146_LRUCache {
    class Entry{
        int key;
        int val;
        Entry prev;
        Entry next;
        Entry(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer, Entry> map;
    Entry head;
    Entry tail;
    int cap;
    public LC146_LRUCache(int capacity) {
        map = new HashMap<>();
        head = null;
        tail = null;
        cap = capacity;
    }

    public int get(int key) {
        Entry cur = map.get(key);
        if(cur==null) return -1;
        // update linkedlist
        if(cur!=head){
            if(cur==tail){
                cur.prev.next = null;
                tail = cur.prev;
            }else{
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
            }
            cur.next = head;
            cur.prev = null;
            head.prev = cur;
            head = cur;
        }
        return cur.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Entry cur = map.get(key);
            if(cur!=head){
                if(cur==tail){
                    cur.prev.next = null;
                    tail = cur.prev;
                }else{
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                cur.next = head;
                cur.prev = null;
                head.prev = cur;
                head = cur;
            }
            cur.val = value;
        }else{
            Entry e = new Entry(key, value);
            if(head==null){
                head = e;
                tail = e;
            }
            else{
                e.next = head;
                head.prev = e;
                head = e;
            }
            if(map.size()==cap){
                tail.prev.next = null;
                map.remove(tail.key);
                tail = tail.prev;
            }
            map.put(key, e);
        }
    }
}
