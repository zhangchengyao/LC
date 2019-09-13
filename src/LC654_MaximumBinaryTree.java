public class LC654_MaximumBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if(left > right) return null;

        int rootIdx = left;
        for(int i = left; i <= right; i++) {
            if(nums[i] > nums[rootIdx]) rootIdx = i;
        }

        TreeNode root = new TreeNode(nums[rootIdx]);
        root.left = construct(nums, left, rootIdx - 1);
        root.right = construct(nums, rootIdx + 1, right);

        return root;
    }
}
