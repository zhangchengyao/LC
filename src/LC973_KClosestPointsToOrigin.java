import java.util.PriorityQueue;

public class LC973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b)->getDist(b)-getDist(a));
        for(int[] point: points){
            maxHeap.offer(point);
            if(maxHeap.size()>K) maxHeap.poll();
        }

        int[][] res = new int[K][2];
        int i = 0;
        for(int[] point: maxHeap){
            res[i++] = point;
        }

        return res;
    }

    private int getDist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
