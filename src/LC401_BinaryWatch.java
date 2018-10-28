import java.util.ArrayList;
import java.util.List;

public class LC401_BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for(byte h=0;h<12;h++){
            int hn = count1(h);
            for(byte m=0;m<60;m++){
                int mn = count1(m);
                if(hn+mn==num){
                    if(m<10) res.add(h+":0"+m);
                    else res.add(h+":"+m);
                }
            }
        }
        return res;
    }
    private int count1(byte n){
        int res = 0;
        while(n!=0){
            if((n&1)==1) res++;
            n >>>= 1;
        }
        return res;
    }
}
