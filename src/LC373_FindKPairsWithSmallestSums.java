import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LC373_FindKPairsWithSmallestSums {
    class Pair{
        int x;
        int y;
        int idx2;
        Pair(int _x, int _y, int _idx2){
            x = _x;
            y = _y;
            idx2 = _idx2;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> pairs = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0) return pairs;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.x+a.y-b.x-b.y);
        int n = nums1.length;
        int m = nums2.length;
        for(int i=0;i<Math.min(k, n);i++){
            pq.offer(new Pair(nums1[i], nums2[0], 0));
        }

        while(!pq.isEmpty() && pairs.size()<k){
            Pair p = pq.poll();
            pairs.add(new int[]{p.x, p.y});
            if(p.idx2!=m-1){
                pq.offer(new Pair(p.x, nums2[p.idx2+1], p.idx2+1));
            }
        }

        return pairs;
    }
}
