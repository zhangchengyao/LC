package advancedAlgo;

import java.util.Arrays;

public class Hungarian {
    private int[][] graph;
    private int[] match;
    private boolean[] visited;
    public Hungarian(int[][] graph){
        this.graph = graph;
        int n = graph[0].length;
        match = new int[n];
        Arrays.fill(match, -1);
        visited = new boolean[n];
    }
    private boolean find(int x){
        for(int y=0;y<graph[0].length;y++){
            if(graph[x][y]==1 && !visited[y]){
                visited[y] = true;
                if(match[y]==-1 || find(match[y])){
                    match[y] = x;
                    return true;
                }
            }
        }
        return false;
    }
    public int hungarian(){
        int res = 0;
        for(int x=0;x<graph.length;x++){
            Arrays.fill(visited, false);
            if(find(x)) res++;
        }
        return res;
    }
}
