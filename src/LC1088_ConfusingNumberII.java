public class LC1088_ConfusingNumberII {
    private int[] cands = {0, 1, 6, 8, 9};
    private int count = 0;

    public int confusingNumberII(int N) {

        countConfusing(Integer.toString(N), new StringBuilder());

        return count;
    }

    private void countConfusing(String N, StringBuilder num) {
        if(num.length() == N.length()) {
            if(num.toString().compareTo(N) <= 0 && isDifferent(num.toString())) count++;
            return;
        }
        if(num.length() > 0 && isDifferent(num.toString())) count++;

        for(int x: cands) {
            if(x == 0 && num.length() == 0) continue;
            num.append(x);
            countConfusing(N, num);
            num.deleteCharAt(num.length() - 1);
        }
    }

    private boolean isDifferent(String num) {
        int i = 0;
        int j = num.length() - 1;
        while(i < j) {
            if(num.charAt(i) == '6') {
                if(num.charAt(j) != '9') return true;
            } else if(num.charAt(i) == '9') {
                if(num.charAt(j) != '6') return true;
            } else {
                if(num.charAt(j) != num.charAt(i)) return true;
            }

            i++;
            j--;
        }

        if(i == j)
            return num.charAt(i) == '6' || num.charAt(i) == '9';

        return false;
    }
}
