import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class LC855_ExamRoom {
    // use priority queue
    class Interval{
        int start;
        int end;
        int dist;
        Interval(int _start, int _end, int _dist){
            start = _start;
            end = _end;
            dist = _dist;
        }
    }

    private PriorityQueue<Interval> pq;
    private int n;
    public LC855_ExamRoom(int N) {
        n = N;
        pq = new PriorityQueue<>((a, b) -> a.dist==b.dist?a.start-b.start:b.dist-a.dist);
        pq.offer(new Interval(-1, N, N));
    }

    public int seat() {
        Interval cur = pq.poll();
        if(cur.start==-1){
            cur.start = 0;
            cur.dist = (cur.end-cur.start)/2;
            pq.offer(cur);
            return 0;
        }else if(cur.end==n){
            cur.end = n-1;
            cur.dist = (cur.end-cur.start)/2;
            pq.offer(cur);
            return n-1;
        }else{
            int pos = cur.start+cur.dist;
            Interval it1 = new Interval(cur.start, pos, (pos-cur.start)/2);
            Interval it2 = new Interval(pos, cur.end, (cur.end-pos)/2);
            pq.offer(it1);
            pq.offer(it2);
            return pos;
        }
    }

    public void leave(int p) {
        List<Interval> list = new ArrayList<>(pq);
        Interval left = null;
        Interval right = null;
        for(Interval it: list){
            if(it.end==p) left = it;
            else if(it.start==p) right = it;
            if(left!=null && right!=null) break;
        }
        pq.remove(left);
        pq.remove(right);
        if(p==0) pq.add(new Interval(-1, right.end, right.end));
        else if(p==n-1) pq.add(new Interval(left.start, n, n-1-left.start));
        else pq.add(new Interval(left.start, right.end, (right.end-left.start)/2));
    }
//    int n;
//    TreeSet<Integer> tset;
//    public LC855_ExamRoom(int N) {
//        n = N;
//        tset = new TreeSet<>();
//    }
//
//    public int seat() {
//        int res = 0;
//        int maxDist = 0;
//        if(!tset.contains(0)){
//            if(tset.higher(0)==null){
//                tset.add(0);
//                return 0;
//            }
//            if(maxDist<tset.higher(0)){
//                maxDist = tset.higher(0);
//                res = 0;
//            }
//        }
//        int cur = 0;
//        while(tset.higher(cur)!=null){
//            int next = tset.higher(cur);
//            if(maxDist<(next-cur)/2){
//                maxDist = (next-cur)/2;
//                res = cur+maxDist;
//            }
//            cur = next;
//        }
//        if(cur!=n-1 && maxDist<n-1-cur) res = n-1;
//        tset.add(res);
//        return res;
//    }
//
//    public void leave(int p) {
//        tset.remove(p);
//    }
}
