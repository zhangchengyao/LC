import java.util.LinkedList;

public class LC547_FriendCircles {
    public int findCircleNum(int[][] M) {
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for(int i=0;i<M.length;i++){
            if(!visited[i]){
                q.clear();
                res++;
                // visit all the nodes connected to this starting node using bfs
                q.offer(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int j=0;j<M.length;j++){
                        if(M[cur][j]==1 && !visited[j]){
                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return res;
    }
}
