import java.util.Arrays;

public class LC455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int j = g.length-1;
        for(int i=s.length-1;i>=0;i--){
            while(j>=0 && g[j]>s[i]) j--;
            if(j>=0){
                res++;
                j--;
            }
        }
        return res;
    }
}
