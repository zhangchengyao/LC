public class LC875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for(int num: piles) max = Math.max(max, num);
        int left = 1;
        int right = max;
        while(left<=right){
            int mid = left + (right-left)/2;
            int totalH = 0;
            for(int num: piles){
                totalH += num%mid==0?num/mid:num/mid+1;
            }
            if(totalH>H) left = mid+1;
            else right = mid-1;
        }
        return left;
    }
}
