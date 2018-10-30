public class LC265_PaintHouseII {
    // O(nk)
    public int minCostII(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int idx = -1;
        for(int j=0;j<costs[0].length;j++){
            if(costs[0][j]<min1){
                min2 = min1;
                min1 = costs[0][j];
                idx = j;
            }
            else if(costs[0][j]<min2){
                min2 = costs[0][j];
            }
        }
        for(int i=1;i<costs.length;i++){
            int preMin1 = min1;
            int preMin2 = min2;
            int preIdx = idx;
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            for(int j=0;j<costs[0].length;j++){
                int cur;
                if(j==preIdx) cur = preMin2 + costs[i][j];
                else cur = preMin1 + costs[i][j];
                if(cur<min1){
                    min2 = min1;
                    min1 = cur;
                    idx = j;
                }
                else if(cur<min2){
                    min2 = cur;
                }

            }
        }
        return min1;
    }
    // O(nk^2)
//    public int minCostII(int[][] costs) {
//        if(costs==null || costs.length==0) return 0;
//        int[][] minCost = new int[costs.length][costs[0].length];
//        for(int j=0;j<costs[0].length;j++) minCost[0][j] = costs[0][j];
//        for(int i=1;i<costs.length;i++){
//            for(int j=0;j<costs[0].length;j++){
//                minCost[i][j] = Integer.MAX_VALUE;
//                for(int k=0;k<costs[0].length;k++){
//                    if(k==j) continue;
//                    minCost[i][j] = Math.min(minCost[i][j], minCost[i-1][k]);
//                }
//                minCost[i][j] += costs[i][j];
//            }
//        }
//        int res = Integer.MAX_VALUE;
//        for(int i=0;i<minCost[costs.length-1].length;i++){
//            res = Math.min(res, minCost[costs.length-1][i]);
//        }
//        return res;
//    }
}
