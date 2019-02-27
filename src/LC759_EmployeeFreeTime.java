import java.util.ArrayList;
import java.util.List;

public class LC759_EmployeeFreeTime {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> working = new ArrayList<>(schedule.get(0));
        for(int i = 1; i < schedule.size(); i++){
            List<Interval> cur = schedule.get(i);
            int k = 0;
            for(Interval it: cur){
                while(k < working.size() && working.get(k).end < it.start) k++;
                if(k == working.size()){
                    working.add(it);
                    k++;
                } else {
                    if(overlap(working.get(k), it)){
                        union(working.get(k), it);
                    } else {
                        working.add(k, it);
                        k++;
                    }
                }
            }
        }

        for(int i = 0; i < working.size() - 1; i++){
            if(overlap(working.get(i), working.get(i + 1))){
                union(working.get(i), working.get(i + 1));
                working.remove(i + 1);
                i--;
            }
        }

        List<Interval> res = new ArrayList<>();
        for(int i = 0; i < working.size() - 1; i++){
            res.add(new Interval(working.get(i).end, working.get(i + 1).start));
        }
        return res;
    }

    private boolean overlap(Interval a, Interval b){
        return !(a.end < b.start || a.start > b.end);
    }

    private void union(Interval a, Interval b){
        a.start = Math.min(a.start, b.start);
        a.end = Math.max(a.end, b.end);
    }
}
