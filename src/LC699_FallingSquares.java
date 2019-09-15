import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class LC699_FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>();

        TreeMap<Integer, Integer> left2Len = new TreeMap<>();
        TreeMap<Integer, Integer> left2Height = new TreeMap<>();

        int highest = 0;
        for(int[] pos: positions) {
            int left = pos[0];
            int len = pos[1];
            int right = left + len;
            int curHeight = len;

            Integer leftItvl = left2Len.lowerKey(left);
            if(leftItvl != null) {
                int end = leftItvl + left2Len.get(leftItvl);
                if(end > left) {
                    curHeight = left2Height.get(leftItvl) + len;
                    if(end > right) {
                        left2Len.put(right, end - right);
                        left2Height.put(right, left2Height.get(leftItvl));
                    }
                    left2Len.put(leftItvl, left - leftItvl);
                }
            }

            Integer rightItvl = left2Len.ceilingKey(left);
            while(rightItvl != null) {
                if(right <= rightItvl) break;

                int end = rightItvl + left2Len.get(rightItvl);
                if(end > right) {
                    left2Len.put(right, end - right);
                    left2Height.put(right, left2Height.get(rightItvl));
                }
                curHeight = Math.max(curHeight, len + left2Height.get(rightItvl));
                left2Len.remove(rightItvl);
                left2Height.remove(rightItvl);
                rightItvl = left2Len.ceilingKey(rightItvl);
            }
            left2Len.put(left, len);
            left2Height.put(left, curHeight);
            highest = Math.max(highest, curHeight);
            ans.add(highest);
        }

        return ans;
    }
}
