public class LC593_ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if(check(p1, p2, p3)){
            int[] dia1 = new int[]{p4[0]-p1[0], p4[1]-p1[1]};
            int[] dia2 = new int[]{p2[0]-p3[0], p2[1]-p3[1]};
            return check(p4, p2, p3) && dia(dia1, dia2);
        }else if(check(p1, p2, p4)){
            int[] dia1 = new int[]{p3[0]-p1[0], p3[1]-p1[1]};
            int[] dia2 = new int[]{p2[0]-p4[0], p2[1]-p4[1]};
            return check(p3, p2, p4) && dia(dia1, dia2);
        }else{
            int[] dia1 = new int[]{p2[0]-p1[0], p2[1]-p1[1]};
            int[] dia2 = new int[]{p4[0]-p3[0], p4[1]-p3[1]};
            return check(p1, p3, p4) && check(p2, p3, p4) && dia(dia1, dia2);
        }
    }
    private boolean check(int[] com, int[] p1, int[] p2){
        return (p1[0]-com[0])*(p2[0]-com[0]) == -(p1[1]-com[1])*(p2[1]-com[1]);
    }
    private boolean dia(int[] a, int[] b){
        if((a[0]==0 && a[1]==0) || (b[0]==0 && b[1]==0)) return false;
        return a[0]*b[0] == -a[1]*b[1];
    }
}
