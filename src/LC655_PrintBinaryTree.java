import java.util.ArrayList;
import java.util.List;

public class LC655_PrintBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<String>> printTree(TreeNode root) {
        int[] info = getWidthAndHeight(root);
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < info[1]; i++) {
            res.add(new ArrayList<>());
            for(int j = 0; j < info[0]; j++) {
                res.get(i).add("");
            }
        }

        print(root, 0, 0, info[0], res);

        return res;
    }

    private int[] getWidthAndHeight(TreeNode root) {
        if(root == null) return new int[]{0, 0};

        int[] res = new int[2];
        int[] leftRes = getWidthAndHeight(root.left);
        int[] rightRes = getWidthAndHeight(root.right);
        res[0] = Math.max(leftRes[0], rightRes[0]) * 2 + 1;
        res[1] = Math.max(leftRes[1], rightRes[1]) + 1;

        return res;
    }

    private void print(TreeNode root, int level, int left, int right, List<List<String>> res) {
        if(root == null) return ;

        int pos = left + (right - left) / 2;
        res.get(level).set(pos, Integer.toString(root.val));
        print(root.left, level + 1, left, pos - 1, res);
        print(root.right, level + 1, pos + 1, right, res);
    }
}
