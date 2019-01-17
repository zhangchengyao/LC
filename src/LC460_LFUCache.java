import java.util.HashMap;

public class LC460_LFUCache {
    class Entry{
        int key;
        int value;
        Entry prev;
        Entry next;
        Entry(int _key, int _value){
            key = _key;
            value = _value;
        }
    }

    class Node{
        int freq;
        Entry head;
        Entry tail;
        Node prev;
        Node next;
        Node(int _freq){
            freq = _freq;
        }
    }

    private int capacity;
    private Node head;
    private HashMap<Integer, Entry> keyToEntry;
    private HashMap<Entry, Node> entryToNode;
    private HashMap<Integer, Node> freqToNode;

    public LC460_LFUCache(int capacity) {
        this.capacity = capacity;
        entryToNode = new HashMap<>();
        keyToEntry = new HashMap<>();
        freqToNode = new HashMap<>();
    }

    public int get(int key) {
        if(!keyToEntry.containsKey(key)){
            return -1;
        }
        else {
            Entry entry = keyToEntry.get(key);
            updateEntryFreq(entry);
            return entry.value;
        }
    }

    public void put(int key, int value) {
        if(keyToEntry.containsKey(key)){
            Entry entry = keyToEntry.get(key);
            entry.value = value;
            updateEntryFreq(entry);
        } else {
            if(keyToEntry.size()==capacity){
                if(capacity==0) return ;
                evict();
            }

            Entry entry = new Entry(key, value);
            keyToEntry.put(key, entry);

            freqToNode.putIfAbsent(1, new Node(1));
            Node node = freqToNode.get(1);
            entryToNode.put(entry, node);

            if(head!=node) insertFirst(node);

            addEntryTo(node, entry);
        }
    }


    private void updateEntryFreq(Entry entry){
        Node original = entryToNode.get(entry);
        int newFreq = original.freq + 1;

        freqToNode.putIfAbsent(newFreq, new Node(newFreq));
        Node newNode = freqToNode.get(newFreq);

        if(original.next!=newNode) insertNodeAfter(original, newNode);

        entryToNode.put(entry, newNode);

        removeEntryFrom(original, entry);
        addEntryTo(newNode, entry);
    }

    private void removeEntryFrom(Node node, Entry entry){
        if(entry==node.head){
            if(entry.next!=null) entry.next.prev = null;
            node.head = entry.next;
        } else {
            entry.prev.next = entry.next;
            if(entry.next!=null) entry.next.prev = entry.prev;
            else node.tail = entry.prev;
        }
        if(node.head==null) removeNode(node);
    }

    private void addEntryTo(Node node, Entry entry){
        if(node.head==null){
            node.head = entry;
            node.tail = node.head;
            entry.prev = null;
            entry.next = null;
        } else {
            entry.prev = null;
            entry.next = node.head;
            node.head.prev = entry;
            node.head = entry;
        }
    }

    private void insertFirst(Node node){
        if(head==null){
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    private void insertNodeAfter(Node original, Node newNode){
        newNode.next = original.next;
        newNode.prev = original;
        if(original.next!=null){
            original.next.prev = newNode;
        }
        original.next = newNode;
    }

    private void removeNode(Node node){
        if(head==node){
            if(head.next!=null){
                head.next.prev = null;
                head = head.next;
            } else {
                head = null;
            }
        } else {
            node.prev.next = node.next;
            if(node.next!=null){
                node.next.prev = node.prev;
            }
        }
    }

    private void evict(){
        keyToEntry.remove(head.tail.key);
        removeEntryFrom(head, head.tail);
    }

    // private void log(){
    //     Node cur = head;
    //     while(cur!=null){
    //         Entry e = cur.head;
    //         while(e!=null){
    //             System.out.print(e.key+"->");
    //             e = e.next;
    //         }
    //         System.out.println();
    //         cur = cur.next;
    //     }
    //     System.out.println();
    //     System.out.println();
    // }

}
