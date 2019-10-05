public class LC875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 0;
        int right = piles[0];
        for(int pile: piles) right = Math.max(right, pile);

        while(left < right) {
            int mid = left + (right - left) / 2;

            int time = 0;
            for(int pile: piles) {
                time += (int)Math.ceil(pile * 1.0 / mid);
            }

            if(time > H) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
