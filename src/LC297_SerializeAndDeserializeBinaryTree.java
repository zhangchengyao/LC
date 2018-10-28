public class LC297_SerializeAndDeserializeBinaryTree {
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
        if(root.left==null && root.right==null){
            sb.append(root.val);
        }else if(root.left==null){
            sb.append(root.val).append("(,").append(serialize(root.right)).append(")");
        }else if(root.right==null){
            sb.append(root.val).append("(").append(serialize(root.left)).append(",)");
        }else{
            sb.append(root.val).append("(").append(serialize(root.left)).append(",").append(serialize(root.right)).append(")");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        int idx = data.indexOf('(');
        if(idx==-1) return new TreeNode(Integer.parseInt(data));
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(0,idx)));
        int comma = idx+1;
        int cnt = 0;
        while(comma<data.length()){
            if(data.charAt(comma)=='(') cnt++;
            else if(data.charAt(comma)==')') cnt--;
            else if(data.charAt(comma)==',' && cnt==0) break;
            comma++;
        }
        root.left = deserialize(data.substring(idx+1, comma));
        root.right = deserialize(data.substring(comma+1, data.length()-1));
        return root;
    }
}
