public class LC1028_RecoverATreeFromPreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode recoverFromPreorder(String S) {
        return recover(S, 0);
    }

    private TreeNode recover(String S, int depth) {
        if(S == null || S.length() == 0) return null;

        int left = -1;
        int right = -1;
        for(int i = 1; i < S.length() - depth - 1; i++) {
            if(S.charAt(i) == '-') {
                int j = i + 1;
                while(j < S.length() && S.charAt(j) == '-') j++;
                if(j - i == depth + 1) {
                    if(left == -1) left = i;
                    else right = i;
                }
                i = j;
            }
            if(right >= 0) break;
        }

        if(left == -1) left = S.length();
        if(right == -1) right = S.length();
        TreeNode root = new TreeNode(Integer.parseInt(S.substring(depth, left)));
        root.left = recover(S.substring(left, right), depth + 1);
        root.right = recover(S.substring(right), depth + 1);

        return root;
    }
}
