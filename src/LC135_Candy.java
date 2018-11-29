import java.util.Arrays;
import java.util.PriorityQueue;

public class LC135_Candy {
    // scan twice
    public int candy(int[] ratings) {
        if(ratings.length==0) return 0;
        if(ratings.length==1) return 1;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) candies[i] = candies[i-1]+1;
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]) candies[i] = Math.max(candies[i], candies[i+1]+1);
        }
        int res = 0;
        for(int candy: candies) res += candy;
        return res;
    }
    // using min heap
//    public int candy(int[] ratings) {
//        if(ratings.length==0) return 0;
//        if(ratings.length==1) return 1;
//        int[][] children = new int[ratings.length][2];
//        int[] candies = new int[ratings.length];
//        for(int i=0;i<ratings.length;i++){
//            children[i][0] = i;
//            children[i][1] = ratings[i];
//            candies[i] = 1;
//        }
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
//        for(int i=0;i<ratings.length;i++) pq.offer(children[i]);
//        for(int i=0;i<ratings.length;i++){
//            int[] cur = pq.poll();
//            if(cur[0]!=0 && ratings[cur[0]]>ratings[cur[0]-1]) candies[cur[0]] = Math.max(candies[cur[0]], candies[cur[0]-1]+1);
//            if(cur[0]<ratings.length-1 && ratings[cur[0]]>ratings[cur[0]+1]) candies[cur[0]] = Math.max(candies[cur[0]], candies[cur[0]+1]+1);
//        }
//        int res = 0;
//        for(int candy: candies) res += candy;
//        return res;
//    }

//    public int candy(int[] ratings) {
//        if(ratings.length==0) return 0;
//        if(ratings.length==1) return 1;
//        int res = 0;
//        int cur = 0;
//        int candy = 1;
//        while(cur<ratings.length){
//            int left = 0;
//            while(cur<ratings.length-1 && ratings[cur]<=ratings[cur+1]){
//                if(cur>0 && ratings[cur]==ratings[cur-1]){
//                    left += 1;
//                    if(ratings[cur]!=ratings[cur+1]) candy = 2;
//                }
//                else left += candy++;
//                cur++;
//            }
//            int curMin;
//            if(cur>0 && ratings[cur]==ratings[cur-1]) curMin = 1;
//            else curMin = candy;
//            int pivot = cur;
//            while(cur<ratings.length-1 && ratings[cur]>=ratings[cur+1]) cur++;
//            int p = cur;
//            int right = 0;
//            candy = 1;
//            while(cur>pivot){
//                if(cur<p && ratings[cur]==ratings[cur+1]){
//                    right += 1;
//                    if(ratings[cur]!=ratings[cur-1]) candy = 2;
//                }
//                else right += candy++;
//                cur--;
//            }
//            res += (left+right+Math.max(candy, curMin));
//            cur = p+1;
//            candy = 2;
//        }
//        return res;
//    }
}
