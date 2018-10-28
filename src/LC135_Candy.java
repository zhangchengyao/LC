public class LC135_Candy {
    public int candy(int[] ratings) {
        if(ratings.length==0) return 0;
        if(ratings.length==1) return 1;
        int res = 0;
        int cur = 0;
        int candy = 1;
        while(cur<ratings.length){
            int left = 0;
            while(cur<ratings.length-1 && ratings[cur]<=ratings[cur+1]){
                if(cur>0 && ratings[cur]==ratings[cur-1]){
                    left += 1;
                    if(ratings[cur]!=ratings[cur+1]) candy = 2;
                }
                else left += candy++;
                cur++;
            }
            int curMin;
            if(cur>0 && ratings[cur]==ratings[cur-1]) curMin = 1;
            else curMin = candy;
            int pivot = cur;
            while(cur<ratings.length-1 && ratings[cur]>=ratings[cur+1]) cur++;
            int p = cur;
            int right = 0;
            candy = 1;
            while(cur>pivot){
                if(cur<p && ratings[cur]==ratings[cur+1]){
                    right += 1;
                    if(ratings[cur]!=ratings[cur-1]) candy = 2;
                }
                else right += candy++;
                cur--;
            }
            res += (left+right+Math.max(candy, curMin));
            cur = p+1;
            candy = 2;
        }
        return res;
    }
}
