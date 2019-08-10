import java.util.*;

public class LC642_DesignSearchAutocompleteSystem {
    static class Node {
        String sentence;
        int hot;
        HashMap<Character, Node> children;
        Node() {
            children = new HashMap<>();
        }
    }

    private Node root;
    private Node cur;
    private String sentence;

    public LC642_DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        root = new Node();
        cur = root;
        sentence = "";
        for(int i = 0; i < sentences.length; i++) {
            String s = sentences[i];
            Node node = root;
            for(char c: s.toCharArray()) {
                if(!node.children.containsKey(c)) {
                    node.children.put(c, new Node());
                }
                node = node.children.get(c);
            }
            node.sentence = s;
            node.hot = times[i];
        }
    }

    public List<String> input(char c) {
        if(c == '#') {
            if(cur.sentence != null) {
                cur.hot++;
            } else {
                cur.sentence = sentence;
                cur.hot = 1;
            }
            sentence = "";
            cur = root;
            return new ArrayList<>();
        } else {
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
            sentence += c;

            PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.hot == y.hot ? y.sentence.compareTo(x.sentence) : x.hot - y.hot);
            Node node = cur;
            search(node, pq);
            List<Node> tmp = new ArrayList<>(pq);
            tmp.sort((x, y) -> x.hot == y.hot ? y.sentence.compareTo(x.sentence) : x.hot - y.hot);

            List<String> res = new ArrayList<>();
            for(int i = tmp.size() - 1; i >= 0; i--) {
                res.add(tmp.get(i).sentence);
            }
            return res;
        }
    }

    private void search(Node cur, PriorityQueue<Node> pq) {
        if(cur == null) return;
        if(cur.sentence != null) {
            pq.offer(cur);
            if(pq.size() > 3) {
                pq.poll();
            }
        }
        for(Node child: cur.children.values()) {
            search(child, pq);
        }
    }
}
