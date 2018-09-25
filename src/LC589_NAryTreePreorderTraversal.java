import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC589_NAryTreePreorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur!=null){
            res.add(cur.val);
            List<Node> children = cur.children;
            for(int i=children.size()-1;i>=0;i--) stack.push(children.get(i));
            if(stack.isEmpty()) break;
            cur = stack.pop();
        }
        return res;
    }
}
