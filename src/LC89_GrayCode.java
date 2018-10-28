import java.util.ArrayList;
import java.util.List;

public class LC89_GrayCode {
    public List<Integer> grayCode(int n) {
        return grayRec(n, 0);
    }
    private List<Integer> grayRec(int n, int start){
        List<Integer> res = new ArrayList<>();
        if(n==0){
            res.add(0);
        }
        else if(n==1){
            res.add(start);
            res.add(start^1);
        }else{
            int leftMost = (start>>>(n-1)) & 1;
            List<Integer> tmp = grayRec(n-1, start-(int)Math.pow(2, n-1)*leftMost);
            for(int i: tmp){
                res.add(leftMost*(int)Math.pow(2, n-1)+i);
            }
            tmp = grayRec(n-1, tmp.get(tmp.size()-1));
            leftMost ^= 1;
            for(int i: tmp){
                res.add(leftMost*(int)Math.pow(2, n-1)+i);
            }
        }
        return res;
    }
}
