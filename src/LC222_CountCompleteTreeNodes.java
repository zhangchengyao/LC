public class LC222_CountCompleteTreeNodes {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        TreeNode l = root.left;
        TreeNode r = root.right;
        int cntL = 0;
        int cntR = 0;
        while(l!=null){
            l = l.left;
            cntL++;
        }
        while(r!=null){
            r = r.right;
            cntR++;
        }
        if(cntL==cntR) return (int)Math.pow(2, cntL+1)-1;
        return (int)Math.pow(2, cntL)-1+countLastLayer(root, cntL);
    }
    private int countLastLayer(TreeNode root, int height){
        if(root==null) return 0;
        if(height==0) return 1;
        TreeNode cur = root.left;
        int h = height;
        while(cur!=null){
            cur = cur.right;
            h--;
        }
        if(h!=0) return countLastLayer(root.left, height-1);
        else return (int)Math.pow(2, height-1)+countLastLayer(root.right, height-1);
    }
}
