import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC305_NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] parent = new int[m*n];
        int num = 0;
        Arrays.fill(parent, -1);
        for(int i=0;i<positions.length;i++){
            int cnt = 0;
            int x = positions[i][0];
            int y = positions[i][1];
            int pos = x*n+y;
            parent[pos] = pos;
            if(x>0 && parent[pos-n]!=-1){
                if(union(pos, pos-n, parent)) cnt++;
            }
            if(x<m-1 && parent[pos+n]!=-1){
                if(union(pos, pos+n, parent)) cnt++;
            }
            if(y>0 && parent[pos-1]!=-1){
                if(union(pos, pos-1, parent)) cnt++;
            }
            if(y<n-1 && parent[pos+1]!=-1){
                if(union(pos, pos+1, parent)) cnt++;
            }
            if(cnt==0) num++;
            else if(cnt>1) num -= (cnt-1);
            res.add(num);
        }
        return res;
    }
    private int find(int a, int[] parent){
        while(parent[a]!=a){
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return a;
    }
    private boolean union(int a, int b, int[] parent){
        int root1 = find(a, parent);
        int root2 = find(b, parent);
        if(root1==root2) return false;
        parent[root1] = root2;
        return true;
    }
}
