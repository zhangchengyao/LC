import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC559_MaximumDepthofNaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if(root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while(!q.isEmpty()){
            int cnt = q.size();
            for(int i = 0; i < cnt; i++){
                Node cur = q.poll();
                if(cur.children != null){
                    for(Node child: cur.children){
                        q.offer(child);
                    }
                }
            }

            depth++;
        }
        return depth;
    }
}
