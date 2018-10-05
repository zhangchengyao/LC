public class LC11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int[] left = new int[height.length]; // left[i] = the tallest in [0, i]
        int[] right = new int[height.length]; // right[i] = the tallest in [i, height.length-1]
        for(int i=0;i<height.length;i++){
            if(i==0) left[i] = height[0];
            else left[i] = Math.max(height[i], left[i-1]);
        }
        for(int i=height.length-1;i>=0;i--){
            if(i==height.length-1) right[i] = height[height.length-1];
            else right[i] = Math.max(height[i], right[i+1]);
        }
        int l = 0;
        int r = height.length-1;
        while(l<r){
            int lower = height[l]>height[r]?height[r]:height[l];
            max = Math.max(max, lower*(r-l));
            if(lower==height[l]){
                l++;
                while(l<height.length && left[l]!=height[l]) l++;
            }else{
                r--;
                while(r>=0 && right[r]!=height[r]) r--;
            }
        }
        return max;
    }
}
