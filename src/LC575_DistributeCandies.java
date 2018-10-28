public class LC575_DistributeCandies {
    public int distributeCandies(int[] candies) {
        // Arrays.sort(candies);
        int num = candies.length/2;
        int kinds = 1;
        for(int i=1;i<candies.length;i++){
            if(candies[i]!=candies[i-1]) kinds++;
        }
        return Math.min(kinds, num);
    }
}
