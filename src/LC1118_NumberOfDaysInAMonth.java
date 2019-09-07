public class LC1118_NumberOfDaysInAMonth {
    public int numberOfDays(int Y, int M) {
        switch(M) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return isLeapYear(Y) ? 29 : 28;
        }
    }

    private boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
    }
}
