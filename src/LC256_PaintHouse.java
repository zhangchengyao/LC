public class LC256_PaintHouse {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        int R = costs[0][0];
        int B = costs[0][1];
        int G = costs[0][2];
        for(int i=1;i<costs.length;i++){
            int prevR = R;
            int prevB = B;
            int prevG = G;
            R = Math.min(prevB, prevG)+costs[i][0];
            B = Math.min(prevR, prevG)+costs[i][1];
            G = Math.min(prevR, prevB)+costs[i][2];
        }
        return Math.min(R, Math.min(B, G));
    }
}
