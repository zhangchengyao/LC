import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC428_SerializeAndDeserializeNaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root==null) return "";
        if(root.children==null || root.children.size()==0) return root.val+"";
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append('(');
        for(Node child: root.children){
            if(first){
                first = false;
                sb.append(serialize(child));
            }
            else{
                sb.append(',').append(serialize(child));
            }
        }
        sb.append(')');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.equals("")) return null;
        int idx = data.indexOf('(');
        if(idx<0) return new Node(Integer.parseInt(data), Arrays.asList());
        Node root = new Node(Integer.parseInt(data.substring(0, idx)), new ArrayList<>());
        int p = idx+1;
        int cnt = 0;
        while(p<data.length()){
            if(data.charAt(p)=='(') cnt++;
            else if(data.charAt(p)==')') cnt--;
            else if(data.charAt(p)==',' && cnt==0){
                Node child = deserialize(data.substring(idx+1, p));
                root.children.add(child);
                idx = p;
            }
            p++;
        }
        root.children.add(deserialize(data.substring(idx+1, p-1)));
        return root;
    }
}
