import java.util.Stack;

public class LC449_SerializeAndDeserializeBST {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while(!stack.isEmpty()){
            cur = stack.pop();
            sb.append(cur.val+",");
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
        return sb.substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] d = data.split(",");
        return decode(d, 0, d.length-1);
    }
    private TreeNode decode(String[] data, int left, int right){
        if(left>right) return null;
        int rootVal = Integer.parseInt(data[left]);
        TreeNode root = new TreeNode(rootVal);
        int i = left+1;
        while(i<=right && rootVal>=Integer.parseInt(data[i])) i++;
        TreeNode l = decode(data, left+1, i-1);
        TreeNode r = decode(data, i, right);
        root.left = l;
        root.right = r;
        return root;
    }
}
