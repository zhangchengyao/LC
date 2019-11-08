public class LC684_RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length];
        for(int i = 0; i < parent.length; i++) parent[i] = i;
        for (int[] edge : edges) {
            if (!union(edge[0] - 1, edge[1] - 1, parent)) return new int[]{edge[0], edge[1]};
        }
        return null;
    }
    private int find(int i, int[] parent) {
        while(parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
    private boolean union(int i, int j, int[] parent){
        int root1 = find(i, parent);
        int root2 = find(j, parent);
        if(root1 == root2) return false;
        parent[root1] = root2;
        return true;
    }
}
