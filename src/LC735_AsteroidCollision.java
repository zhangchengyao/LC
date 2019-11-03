public class LC735_AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int i = -1;
        for(int j = 0; j < asteroids.length; j++) {
            if(asteroids[j] > 0) {
                asteroids[++i] = asteroids[j];
            } else {
                while(i >= 0 && asteroids[i] > 0 && asteroids[i] < Math.abs(asteroids[j])) i--;
                if(i < 0 || asteroids[i] < 0) {
                    asteroids[++i] = asteroids[j];
                } else if(asteroids[i] == Math.abs(asteroids[j])) {
                    i--;
                }
            }
        }

        int[] res = new int[i + 1];
        while(i >= 0) res[i] = asteroids[i--];
        return res;
    }
}
