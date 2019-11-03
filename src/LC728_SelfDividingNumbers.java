import java.util.ArrayList;
import java.util.List;

public class LC728_SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(check(i)) res.add(i);
        }
        return res;
    }
    private boolean check(int num){
        int n;
        int tmp = num;
        while(tmp != 0){
            n = tmp % 10;
            if(n == 0 || num % n != 0) return false;
            tmp /= 10;
        }
        return true;
    }
}
