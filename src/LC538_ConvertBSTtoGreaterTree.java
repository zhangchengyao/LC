import java.util.ArrayList;
import java.util.List;

public class LC538_ConvertBSTtoGreaterTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // recursive solution
//    private int sum = 0;
//
//    public TreeNode convertBST(TreeNode root) {
//        if(root==null) return null;
//
//        convertBST(root.right);
//        int tmp = root.val;
//        root.val += sum;
//        sum += tmp;
//        convertBST(root.left);
//
//        return root;
//    }

    public TreeNode convertBST(TreeNode root) {
        List<Integer> sum = new ArrayList<>();

        inorder(root, sum, false);
        inorder(root, sum, true);

        return root;
    }

    private void inorder(TreeNode root, List<Integer> sum, boolean modify){
        TreeNode cur = root;
        TreeNode prev = null;
        int idx = 0;
        while(cur!=null){
            if(cur.left==null){
                if(modify) cur.val += sum.get(sum.size()-1) - sum.get(idx);
                else sum.add(idx==0?cur.val:sum.get(sum.size()-1)+cur.val);
                idx++;
                cur = cur.right;
            } else {
                prev = cur.left;
                while(prev.right!=null && prev.right!=cur) prev = prev.right;

                if(prev.right==null){
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    if(modify) cur.val += sum.get(sum.size()-1) - sum.get(idx);
                    else sum.add(idx==0?cur.val:sum.get(sum.size()-1)+cur.val);
                    idx++;
                    cur = cur.right;
                }
            }
        }
    }
}
