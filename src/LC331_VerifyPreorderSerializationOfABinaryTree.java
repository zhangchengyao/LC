import java.util.Stack;

public class LC331_VerifyPreorderSerializationOfABinaryTree {
    class Node{
        boolean hasLeft;
        boolean hasRight;
    }
    public boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder.equals("")) return true;

        String[] values = preorder.split(",");
        Stack<Node> stack = new Stack<>();
        if(!values[0].equals("#")) stack.push(new Node());

        for(int i=1;i<values.length;i++){
            if(values[i].equals("#")){
                if(stack.isEmpty()) return false;
                if(stack.peek().hasLeft) stack.peek().hasRight = true;
                else stack.peek().hasLeft = true;
                while(!stack.isEmpty() && stack.peek().hasRight) stack.pop();
            } else {
                if(stack.isEmpty()) return false;
                if(stack.peek().hasLeft) stack.peek().hasRight = true;
                else stack.peek().hasLeft = true;
                stack.push(new Node());
            }
        }

        return stack.isEmpty();
    }
}
