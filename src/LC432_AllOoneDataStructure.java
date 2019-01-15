import java.util.HashMap;
import java.util.HashSet;

public class LC432_AllOoneDataStructure {
    class Node{
        int val;
        Node prev;
        Node next;
        HashSet<String> keys;
        Node(int _val){
            val = _val;
            keys = new HashSet<>();
        }
    }

    HashMap<String, Node> map;
    HashMap<Integer, Node> valueMap;
    Node head;
    Node tail;
    /** Initialize your data structure here. */
    public LC432_AllOoneDataStructure() {
        map = new HashMap<>();
        valueMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(!map.containsKey(key)){
            valueMap.putIfAbsent(1, new Node(1));
            Node node = valueMap.get(1);
            node.keys.add(key);
            if(head!=node){
                node.next = head;
                if(head!=null) head.prev = node;
                head = node;
            }
            if(tail==null) tail = node;
            map.put(key, node);
        } else {
            Node original = map.get(key);
            int value = original.val + 1;
            if(original.next!=null && original.next.val==value){
                original.next.keys.add(key);
                map.put(key, original.next);
            } else {
                Node newNode = new Node(value);
                newNode.keys.add(key);
                insertAfter(original, newNode);
                valueMap.put(newNode.val, newNode);
                map.put(key, newNode);
            }
            original.keys.remove(key);
            if(original.keys.isEmpty()) removeNode(original);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!map.containsKey(key)) return ;
        Node original = map.get(key);
        int value = original.val - 1;
        if(value!=0){
            if(original.prev!=null && original.prev.val==value){
                original.prev.keys.add(key);
                map.put(key, original.prev);
            } else {
                Node newNode = new Node(value);
                newNode.keys.add(key);
                map.put(key, newNode);
                if(original.prev==null){
                    newNode.next = original;
                    original.prev = newNode;
                    head = newNode;
                } else {
                    insertAfter(original.prev, newNode);
                }
                valueMap.put(newNode.val, newNode);
            }
        } else {
            map.remove(key);
        }
        original.keys.remove(key);
        if(original.keys.isEmpty()) removeNode(original);
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(tail==null) return "";
        return tail.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(head==null) return "";
        return head.keys.iterator().next();
    }

    private void insertAfter(Node node, Node newNode){
        if(node.next==null){
            node.next = newNode;
            newNode.prev = node;
            tail = newNode;
        } else {
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
            newNode.prev = node;
        }
    }

    private void removeNode(Node node){
        if(head==node){
            head = head.next;
            if(head!=null) head.prev = null;
            else tail = null;
        } else {
            node.prev.next = node.next;
            if(node.next!=null) node.next.prev = node.prev;
            else tail = node.prev;
        }
        valueMap.remove(node.val);
    }
}
