public class LC755_PourWater {
    public int[] pourWater(int[] heights, int V, int K) {
        while(V > 0){
            int l = indexLeftMin(heights, K);
            if(l != K){
                heights[l]++;
            } else {
                int r = indexRightMin(heights, K);
                heights[r]++;
            }
            V--;
        }

        return heights;
    }

    private int indexLeftMin(int[] heights, int K){
        int min = K;
        for(int i = K - 1; i >= 0; i--){
            if(heights[i] < heights[min]){
                min = i;
            } else if(heights[i] > heights[i+1]){
                break;
            }
        }

        return min;
    }

    private int indexRightMin(int[] heights, int K){
        int min = K;
        for(int i = K + 1; i < heights.length; i++){
            if(heights[i] < heights[min]){
                min = i;
            } else if(heights[i] > heights[i-1]){
                break;
            }
        }

        return min;
    }
}
