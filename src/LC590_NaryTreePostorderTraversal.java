import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC590_NaryTreePostorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;
        stack.push(cur);
        while(!stack.isEmpty()){
            cur = stack.peek();
            boolean flag = false;
            if(cur.children.size()==0) flag = true;
            else{
                for(Node node: cur.children){
                    if(prev!=null && prev==node){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                res.add(cur.val);
                stack.pop();
                prev = cur;
            }
            else{
                for(int i=cur.children.size()-1;i>=0;i--){
                    stack.push(cur.children.get(i));
                }
            }
        }
        return res;
    }
}
