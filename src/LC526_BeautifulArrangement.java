import java.util.ArrayList;
import java.util.List;

public class LC526_BeautifulArrangement {
    public int countArrangement(int N) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=N;i++) list.add(i);
        return count(1, list);
    }
    private int count(int start, List<Integer> list){
        if(list.size()==1){
            if(start%list.get(0)==0 || list.get(0)%start==0) return 1;
            else return 0;
        }
        int res = 0;
        for(int i=0;i<list.size();i++){
            if(start%list.get(i)==0 || list.get(i)%start==0){
                int cur = list.remove(i);
                res += count(start+1, list);
                list.add(i, cur);
            }
        }
        return res;
    }
}
