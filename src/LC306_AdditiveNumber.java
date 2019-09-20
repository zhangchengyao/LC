public class LC306_AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return isAdditive(num, 0, "", "");
    }

    private boolean isAdditive(String num, int idx, String prev2, String prev1) {
        if(idx == num.length()) return true;

        for(int i = idx + 1; i <= num.length(); i++) {
            if(i > idx + 1 && num.charAt(idx) == '0') break;

            String cur = num.substring(idx, i);

            if(prev2.length() == 0 && prev1.length() == 0) {
                if(i == num.length()) return false;
                if(isAdditive(num, i, cur, prev1)) {
                    return true;
                }
            } else if(prev1.length() == 0) {
                if(i == num.length()) return false;
                if(isAdditive(num, i, prev2, cur)) {
                    return true;
                }
            } else {
                String sum = add(prev2, prev1);
                if(cur.equals(sum)) return isAdditive(num, i, prev1, cur);
                else if(largerThan(cur, sum)) break;
            }
        }

        return false;
    }

    private String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 && j >= 0) {
            int x = a.charAt(i--) - '0';
            int y = b.charAt(j--) - '0';
            int val = x + y + carry;
            carry = val / 10;
            val %= 10;
            sb.append(val);
        }

        while(i >= 0) {
            int x = a.charAt(i--) - '0';
            int val = x + carry;
            carry = val / 10;
            val %= 10;
            sb.append(val);
        }
        while(j >= 0) {
            int y = b.charAt(j--) - '0';
            int val = y + carry;
            carry = val / 10;
            val %= 10;
            sb.append(val);
        }

        if(carry == 1) sb.append(1);

        return sb.reverse().toString();
    }

    private boolean largerThan(String a, String b) {
        if(a.length() > b.length()) return true;
        else if(a.length() < b.length()) return false;
        else return a.compareTo(b) > 0;
    }
}
