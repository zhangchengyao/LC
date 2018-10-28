public class LC657_RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int U = 0;
        int D = 0;
        int L = 0;
        int R = 0;
        for(int i=0;i<moves.length();i++){
            char c = moves.charAt(i);
            switch(c){
                case 'U':
                    U++;
                    break;
                case 'D':
                    D++;
                    break;
                case 'L':
                    L++;
                    break;
                case 'R':
                    R++;
                    break;
                default:
                    break;
            }
        }
        return U==D && L==R;
    }
}
