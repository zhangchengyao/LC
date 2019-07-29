public class LC536_ConstructBinaryTreeFromString {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode str2tree(String s) {
        if(s == null || s.equals("")) return null;

        int idx = s.indexOf("(");
        TreeNode root;
        if(idx > 0) {
            int val = Integer.parseInt(s.substring(0, idx));
            root = new TreeNode(val);
            int idxRight = getRightPos(s, idx);
            root.left = str2tree(s.substring(idx + 1, idxRight));

            if(idxRight < s.length() - 1){
                root.right = str2tree(s.substring(idxRight + 2, s.length() - 1));
            }
        } else {
            root = new TreeNode(Integer.parseInt(s));
        }
        return root;
    }

    private int getRightPos(String s, int idx) {
        int cnt = 1;
        for(int i = idx + 1; i < s.length(); i++) {
            if(s.charAt(i) == '(') cnt++;
            else if(s.charAt(i) == ')') cnt--;

            if(cnt == 0) return i;
        }

        return -1;
    }
}
