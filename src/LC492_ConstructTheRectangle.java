public class LC492_ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        for(int width=(int)Math.sqrt(area);width>=1;width--){
            if(area%width==0){
                return new int[]{area/width, width};
            }
        }
        return null;
    }
}
