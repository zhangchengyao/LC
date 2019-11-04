public class LC657_RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int r = 0;
        int c = 0;
        for(int i = 0; i < moves.length(); i++){
            char ch = moves.charAt(i);
            switch(ch){
                case 'U':
                    r--;
                    break;
                case 'D':
                    r++;
                    break;
                case 'L':
                    c--;
                    break;
                case 'R':
                    c++;
                    break;
                default:
                    break;
            }
        }
        return r == 0 && c == 0;
    }
}
