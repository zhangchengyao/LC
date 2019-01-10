public class LC129_SumRootToLeafNumbers {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        getSum(root, new StringBuilder());
        return sum;
    }

    private void getSum(TreeNode root, StringBuilder number){
        if(root==null) return ;

        number.append(root.val);
        if(root.left==null && root.right==null){
            sum += Integer.parseInt(number.toString());
            number.deleteCharAt(number.length()-1);
            return ;
        }

        getSum(root.left, number);
        getSum(root.right, number);
        number.deleteCharAt(number.length()-1);
    }
}
