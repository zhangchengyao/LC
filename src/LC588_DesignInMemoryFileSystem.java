import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LC588_DesignInMemoryFileSystem {
    class Node {
        String name;
        HashMap<String, Node> children;
        String content;

        Node(String _name) {
            name = _name;
        }
    }

    private Node root;

    public LC588_DesignInMemoryFileSystem() {
        root = new Node("/");
        root.children = new HashMap<>();
    }

    public List<String> ls(String path) {
        String[] paths = path.split("/");
        Node cur = root;
        for(String p: paths) {
            if(p.equals("")) continue;
            cur = cur.children.get(p);
        }
        if(cur.children == null) {
            return Collections.singletonList(cur.name);
        } else {
            List<String> res = new ArrayList<>(cur.children.keySet());
            Collections.sort(res);
            return res;
        }
    }

    public void mkdir(String path) {
        String[] paths = path.split("/");
        Node cur = root;
        for(String p: paths) {
            if(p.equals("")) continue;
            if(!cur.children.containsKey(p)) {
                cur.children.put(p, new Node(p));
                cur.children.get(p).children = new HashMap<>();
            }
            cur = cur.children.get(p);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] paths = filePath.split("/");
        Node cur = root;
        for(String p: paths) {
            if(p.equals("")) continue;
            if(!cur.children.containsKey(p)) {
                cur.children.put(p, new Node(p));
                cur.children.get(p).content = content;
                return;
            }
            cur = cur.children.get(p);
        }
        cur.content += content;
    }

    public String readContentFromFile(String filePath) {
        String[] paths = filePath.split("/");
        Node cur = root;
        for(String p: paths) {
            if(p.equals("")) continue;
            cur = cur.children.get(p);
        }
        return cur.content;
    }
}