public class LC70_ClimbingStairs {
    public int climbStairs(int n) {
        int p = 1;
        int q = 1;
        for(int i=2;i<=n;i++){
            int tmp = p;
            p = p+q;
            q = tmp;
        }
        return p;
    }
}
