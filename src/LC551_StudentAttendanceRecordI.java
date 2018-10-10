public class LC551_StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int cntA = 0;
        int cntL = 0;
        int curL = 0;
        char[] str = s.toCharArray();
        for(int i=0;i<str.length;i++){
            if(str[i]=='A'){
                cntA++;
                cntL = Math.max(cntL, curL);
                curL = 0;
            }
            else if(str[i]=='L'){
                curL++;
            }else{
                cntL = Math.max(cntL, curL);
                curL = 0;
            }
        }
        cntL = Math.max(cntL, curL);
        return cntA<=1 && cntL<=2;
    }
}
