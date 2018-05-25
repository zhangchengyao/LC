public class LC109_ConvertSortedListToBinarySearchTree {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int length = 0;
        while(p!=null){
            length++;
            p = p.next;
        }
        return convert(head, length);
    }
    private TreeNode convert(ListNode head, int length){
        if(head==null || length<=0) return null;
        int middle = length/2;
        ListNode p = head;
        for(int i=0;i<middle;i++){
            p = p.next;
        }
        TreeNode root = new TreeNode(p.val);
        root.left = convert(head, middle);
        root.right = convert(p.next, length-middle-1);
        return root;
    }
}
