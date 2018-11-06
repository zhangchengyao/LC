package advancedAlgo;

import java.util.Arrays;

public class KM {
    private int[][] graph;
    private int[] expX;
    private int[] expY;
    private boolean[] visitX;
    private boolean[] visitY;
    private int[] match;
    private int slack;
    public KM(int[][] graph){
        this.graph = graph;
        int N = graph.length;
        expX = new int[N];
        expY = new int[N];
        visitX = new boolean[N];
        visitY = new boolean[N];
        match = new int[N];
        Arrays.fill(match, -1);
        slack = Integer.MAX_VALUE;
    }
    private boolean find(int x){
        visitX[x] = true;
        for(int y=0;y<graph.length;y++){
            if(visitY[y]) continue;
            int gap = expX[x] + expY[y] - graph[x][y];
            if(gap==0){
                visitY[y] = true;
                if(match[y]==-1 || find(match[y])){
                    match[y] = x;
                    return true;
                }
            }
            else{
                slack = Math.min(slack, gap);
            }
        }
        return false;
    }
    public int KM(){
        for(int x=0;x<graph.length;x++){
            for(int y=0;y<graph.length;y++){
                expX[x] = Math.max(expX[x], graph[x][y]);
            }
        }

        for(int x=0;x<graph.length;x++){
            slack = Integer.MAX_VALUE;
            while(true){
                Arrays.fill(visitX, false);
                Arrays.fill(visitY, false);

                if(find(x)) break;

                for(int i=0;i<graph.length;i++){
                    if(visitX[i]) expX[i] -= slack;
                    if(visitY[i]) expY[i] += slack;
                }
            }
        }

        int res = 0;
        for(int i=0;i<graph.length;i++){
            res += graph[match[i]][i];
        }
        return res;
    }
}
