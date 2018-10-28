import java.util.Arrays;

public class LC685_RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length];
        Arrays.fill(parent, -1);
        int[] first = null; // the first edge pointing to vertex with in-degree 2
        int[] second = null; // the second edge pointing to vertex with in-degree 2
        for(int i=0;i<edges.length;i++){
            int from = edges[i][0]-1;
            int to = edges[i][1]-1;
            if(parent[to]!=-1){
                first = new int[]{parent[to], to};
                second = new int[]{from, to};
            }
            parent[to] = from;
        }
        for(int i=0;i<edges.length;i++){
            parent[i] = i;
        }
        if(first==null){
            for(int i=0;i<edges.length;i++){
                int from = edges[i][0]-1;
                int to = edges[i][1]-1;
                int pFrom = find(from, parent);
                if(pFrom==to) return new int[]{from+1, to+1};
                parent[to] = from;
            }
        }else{
            for(int i=0;i<edges.length;i++){
                int from = edges[i][0]-1;
                int to = edges[i][1]-1;
                if(from==second[0] && to==second[1]) continue;
                int pFrom = find(from, parent);
                if(pFrom==to) return new int[]{first[0]+1, first[1]+1};
                parent[to] = from;
            }
        }
        return new int[]{second[0]+1, second[1]+1};
    }
    private int find(int i, int[] parent){
        while(parent[i]!=i){
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
