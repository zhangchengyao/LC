import java.util.HashMap;

public class LC96_UniqueBinarySearchTrees {
    HashMap<String, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if(n<1) return 0;
        return calculate(1, n);
    }
    private int calculate(int l, int r){
        if(l>r) return 1;
        String str = l+" "+r;
        if(map.containsKey(str)) return map.get(str);
        int res = 0;
        for(int i=l;i<=r;i++){
            int left = calculate(l, i-1);
            int right = calculate(i+1, r);
            res += left*right;
        }
        map.put(str, res);
        return res;
    }
}
