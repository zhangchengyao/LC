public class LC735_AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int left = 0;
        int right = 1;

        while(right < asteroids.length) {
            if(left == -1) {
                left++;
                asteroids[left] = asteroids[right];
                right++;
            } else if(asteroids[right] < 0 && asteroids[left] > 0) {
                if(asteroids[left] == -asteroids[right]) {
                    left--;
                    right++;
                } else if(asteroids[left] < -asteroids[right]) {
                    left--;
                } else {
                    right++;
                }
            } else {
                left++;
                asteroids[left] = asteroids[right];
                right++;
            }
        }

        int[] res = new int[left + 1];
        for(int i = 0; i <= left; i++) {
            res[i] = asteroids[i];
        }

        return res;
    }
}
