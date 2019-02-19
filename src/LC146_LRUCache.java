import java.util.HashMap;
import java.util.LinkedHashMap;

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
    private HashMap<Integer, Entry> map;
    private Entry head;
    private Entry tail;
    private int capacity;
    public LC146_LRUCache(int capacity) {
        map = new HashMap<>();
        head = null;
        tail = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        Entry cur = map.get(key);
        if(cur == null) return -1;

        // update linkedlist
        if(cur != head){
            removeEntry(cur);
            addFirst(cur);
        }
        return cur.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Entry cur = map.get(key);
            if(cur != head){
                removeEntry(cur);
                addFirst(cur);
            }
            cur.val = value;
        } else {
            Entry e = new Entry(key, value);
            addFirst(e);

            if(map.size() == capacity){
                map.remove(tail.key);
                removeEntry(tail);
            }

            map.put(key, e);
        }
    }

    private void removeEntry(Entry e){
        if(e == head){
            head = null;
            tail = null;
            return;
        }

        e.prev.next = e.next;
        if(e != tail){
            e.next.prev = e.prev;
        } else {
            tail = e.prev;
        }
    }

    private void addFirst(Entry e){
        e.next = head;
        e.prev = null;

        if(head == null){
            head = e;
            tail = e;
        } else {
            head.prev = e;
            head = e;
        }
    }

    // use LinkedHashMap
//    LinkedHashMap<Integer, Integer> lmap;
//    int capacity;
//
//    public LRUCache(int capacity) {
//        lmap = new LinkedHashMap<>(capacity, 0.75f, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if(!lmap.containsKey(key)){
//            return -1;
//        }
//
//        return lmap.get(key);
//    }
//
//    public void put(int key, int value) {
//        lmap.put(key, value);
//        if(lmap.size() > capacity){
//            int oldest = lmap.keySet().iterator().next();
//            lmap.remove(oldest);
//        }
//    }
}
