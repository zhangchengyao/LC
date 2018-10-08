public class LC684_RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length];
        for(int i=0;i<parent.length;i++) parent[i] = i;
        for(int i=0;i<edges.length;i++){
            if(!union(edges[i][0]-1, edges[i][1]-1, parent)) return new int[]{edges[i][0],edges[i][1]};
        }
        return null;
    }
    private int find(int i, int[] arr){
        while(arr[i]!=i){
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }
    private boolean union(int i, int j, int[] arr){
        int root1 = find(i, arr);
        int root2 = find(j, arr);
        if(root1==root2) return false;
        arr[root1] = root2;
        return true;
    }
}
