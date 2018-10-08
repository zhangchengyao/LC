import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC305_NumberOfIslandsII {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> list = new ArrayList<>();
        if(operators==null || operators.length==0 || n<=0 || m<=0) return list;
        int[] arr = new int[n*m];
        int[] size = new int[n*m];
        Arrays.fill(arr, -1);
        Arrays.fill(size, 1);
        int num = 0;
        for(int i=0;i<operators.length;i++){
            Point p = operators[i];
            int number = p.x*m+p.y;
            if(arr[number]>=0){
                list.add(num);
                continue;
            }
            arr[number] = number;
            boolean firstUnion = true;
            if(check(p.x-1, p.y, n, m, arr)){
                boolean res = union(number-m, number, arr, size);
                firstUnion = false;
            }
            if(check(p.x+1, p.y, n, m, arr)){
                boolean res = union(number+m, number, arr, size);
                if(res && !firstUnion) num--;
                firstUnion = false;
            }
            if(check(p.x, p.y-1, n, m, arr)){
                boolean res = union(number-1, number, arr, size);
                if(res && !firstUnion) num--;
                firstUnion = false;
            }
            if(check(p.x, p.y+1, n, m, arr)){
                boolean res = union(number+1, number, arr, size);
                if(res && !firstUnion) num--;
                firstUnion = false;
            }
            if(firstUnion){
                num++;
            }
            list.add(num);
        }
        return list;
    }
    private boolean check(int x, int y, int n, int m, int[] arr){
        // return 1 if (x, y) is land
        if(x<0 || x>=n || y<0 || y>=m) return false;
        return arr[x*m+y]>=0;
    }
    private int find(int i, int[] arr){
        while(arr[i]!=i){
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }
    private boolean union(int i, int j, int[] arr, int[] size){
        int root1 = find(i, arr);
        int root2 = find(j, arr);
        if(root1==root2) return false; // already in the same group
        else{
            if(size[i]>size[j]){
                arr[root2] = root1;
                size[i] += size[j];
            }else{
                arr[root1] = root2;
                size[j] += size[i];
            }
            return true;
        }
    }
}
