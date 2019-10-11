import java.util.HashMap;
import java.util.Map;

public class LC889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < pre.length; i++) map.put(pre[i], i);

        return construct(pre, 0, pre.length - 1, post, 0, post.length - 1, map);
    }

    private TreeNode construct(int[] pre, int prel, int prer, int[] post, int postl, int postr, Map<Integer, Integer> map) {
        if(prel == prer) return new TreeNode(pre[prel]);
        if(prel > prer) return null;

        TreeNode root = new TreeNode(pre[prel]);
        int rightIdx = map.get(post[postr - 1]);
        root.left = construct(pre, prel + 1, rightIdx - 1, post, postl, postl + rightIdx - prel - 2, map);
        root.right = construct(pre, rightIdx, prer, post, postl + rightIdx - prel - 1, postr - 1, map);

        return root;
    }
}
