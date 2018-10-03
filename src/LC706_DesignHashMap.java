import java.util.LinkedList;

public class LC706_DesignHashMap {
    class Entry{
        int key;
        int val;
        Entry(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    LinkedList[] data;
    /** Initialize your data structure here. */
    public LC706_DesignHashMap() {
        data  = new LinkedList[9737];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        if(data[h]==null) data[h] = new LinkedList<>();
        LinkedList<Entry> list = data[h];
        for(int i=0;i<list.size();i++){
            if(list.get(i).key==key){
                list.get(i).val = value;
                return;
            }
        }
        Entry e = new Entry(key, value);
        list.addFirst(e);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        LinkedList<Entry> list = data[h];
        if(list==null) return -1;
        for(int i=0;i<list.size();i++){
            if(list.get(i).key==key) return list.get(i).val;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        LinkedList<Entry> list = data[h];
        if(list==null) return;
        for(int i=0;i<list.size();i++){
            if(list.get(i).key==key){
                list.remove(i);
                break;
            }
        }
    }
    private int hash(int x){
        return x%9737;
    }
}