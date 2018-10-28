public class LC427_ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
    public Node construct(int[][] grid) {
        int n = grid.length;
        return helper(grid, 0, 0, n-1, n-1);
    }
    private Node helper(int[][] grid, int x1, int y1, int x2, int y2){
        boolean isLeaf = true;
        int t = grid[x1][y1];
        for(int i=x1;i<=x2;i++){
            for(int j=y1;j<=y2;j++){
                if(grid[i][j]!=t){
                    isLeaf = false;
                    break;
                }
            }
            if(!isLeaf) break;
        }
        Node node = null;
        if(isLeaf){
            node = new Node(t==1?true:false, true, null, null, null, null);
        }
        else{
            int d = (x2-x1)/2;
            Node topLeft = helper(grid, x1, y1, x1+d, y1+d);
            Node topRight = helper(grid, x1, y2-d, x1+d, y2);
            Node bottomLeft = helper(grid, x2-d, y1, x2, y1+d);
            Node bottomRight = helper(grid, x2-d, y2-d, x2, y2);
            node = new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
        return node;
    }
}
