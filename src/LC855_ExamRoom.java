import java.util.TreeSet;

public class LC855_ExamRoom {
    // todo
    int n;
    TreeSet<Integer> tset;
    public LC855_ExamRoom(int N) {
        n = N;
        tset = new TreeSet<>();
    }

    public int seat() {
        int res = 0;
        int maxDist = 0;
        if(!tset.contains(0)){
            if(tset.higher(0)==null){
                tset.add(0);
                return 0;
            }
            if(maxDist<tset.higher(0)){
                maxDist = tset.higher(0);
                res = 0;
            }
        }
        if(!tset.contains(n-1)){
            if(maxDist<n-1-tset.lower(n-1)){
                maxDist = n-1-tset.lower(n-1);
                res = n-1;
            }
        }
        int cur = 0;
        while(tset.higher(cur)!=null){
            int next = tset.higher(cur);
            if(maxDist<(next-cur)/2){
                maxDist = (next-cur)/2;
                res = cur+maxDist;
            }
            else if(maxDist==(next-cur)/2) res = Math.min(res, cur+maxDist);
            cur = next;
        }
        tset.add(res);
        return res;
    }

    public void leave(int p) {
        tset.remove(p);
    }
}
