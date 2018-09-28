import java.util.PriorityQueue;

public class LC378_KthSmallestElementInASortedMatrix {
    // binary search?
//    public int kthSmallest(int[][] matrix, int k) {
//        int n = matrix.length;
//        int left =  matrix[0][0];
//        int right = matrix[n-1][n-1];
//        int cnt = 0;
//        while(left<right){
//            cnt = 0;
//            int mid = left + (right-left)/2;
//            for(int i=0;i<n;i++){
//                for(int j=0;j<n;j++){
//                    if(matrix[i][j]<=mid) cnt++;
//                    else break;
//                }
//            }
//            if(cnt<k) left = mid+1;
//            else right = mid;
//        }
//        return right;
//    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pq.offer(matrix[i][j]);
            }
        }
        for(int i=1;i<k;i++){
            pq.poll();
        }
        return pq.peek();
    }
}
