public class LC255_VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;

        return verify(preorder, 0, preorder.length - 1, null, null);
    }

    private boolean verify(int[] preorder, int left, int right, Integer lower, Integer upper) {
        if(left >= right) return true;

        int root = preorder[left];

        int split = left + 1;
        while(split <= right && preorder[split] < root) {
            if((lower != null && preorder[split] < lower) || (upper != null && preorder[split] > upper)) return false;
            split++;
        }

        return verify(preorder, left + 1, split - 1, lower, root) && verify(preorder, split, right, root, upper);
    }
}
