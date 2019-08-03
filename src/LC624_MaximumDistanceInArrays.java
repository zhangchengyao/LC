import java.util.List;

public class LC624_MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        int secMin = Integer.MAX_VALUE;
        int secMax = Integer.MIN_VALUE;
        for(int i = 0; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int curMin = array.get(0);
            int curMax = array.get(array.size() - 1);
            if(curMin < min) {
                secMin = min;
                min = curMin;
                minIdx = i;
            } else if(curMin < secMin) {
                secMin = curMin;
            }

            if(curMax > max) {
                secMax = max;
                max = curMax;
                maxIdx = i;
            } else if(curMax > secMax) {
                secMax = curMax;
            }
        }

        if(minIdx != maxIdx) {
            return max - min;
        } else {
            return Math.max(max - secMin, secMax - min);
        }
    }
}
