import java.util.ArrayList;
import java.util.List;

public class LC386_LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        int i = 1;
        while(true){
            res.add(i);
            cnt++;
            if(cnt==n) break;
            while(i*10<=n){
                i *= 10;
                res.add(i);
                cnt++;
                if(cnt==n) break;
            }
            if(i%10==9 || i==n){
                i /= 10;
                while(i%10==9) i /= 10;
            }
            i++;
        }
        return res;
    }
}
