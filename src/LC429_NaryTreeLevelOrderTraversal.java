import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC429_NaryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int cnt = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<cnt;i++){
                Node cur = q.poll();
                level.add(cur.val);
                if(cur.children!=null){
                    for(Node child: cur.children){
                        q.offer(child);
                    }
                }
            }
            res.add(level);
        }

        return res;
    }
}
