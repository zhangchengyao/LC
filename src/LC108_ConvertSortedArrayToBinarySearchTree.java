public class LC108_ConvertSortedArrayToBinarySearchTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length-1);
    }
    private TreeNode convert(int[] nums, int left, int right){
        if(nums==null || left>right) return null;
        int middle = (left+right)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = convert(nums, left, middle-1);
        root.right = convert(nums, middle+1, right);
        return root;
    }
}
