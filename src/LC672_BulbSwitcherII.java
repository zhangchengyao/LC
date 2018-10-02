public class LC672_BulbSwitcherII {
    public int flipLights(int n, int m) {
        if(n==0 || m==0) return 1;
        if(n==1) return 2;
        if(n==2) return m==1?3:4;
        if(m==1) return 4;
        else if (m==2) return 7;
        else return 8;
    }
}
