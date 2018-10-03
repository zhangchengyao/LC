public class LC223_RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (D-B)*(C-A);
        int area2 = (H-F)*(G-E);
        int overlap = 0;
        if(!(B>=H || D<=F || A>=G || C<=E)){
            int height = Math.min(D, H)-Math.max(B, F);
            int width = Math.min(C, G)-Math.max(A, E);
            overlap = width * height;
        }
        return area1+area2-overlap;
    }
}
