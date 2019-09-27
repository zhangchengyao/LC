public class LC831_MaskingPersonalInformation {
    public String maskPII(String S) {
        if(S.contains("@")) {
            S = S.toLowerCase();
            int atIdx = S.indexOf("@");
            StringBuilder sb = new StringBuilder();
            sb.append(S.charAt(0)).append("*****").append(S.substring(atIdx - 1));

            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            int digitCount = 0;
            for(int i = S.length() - 1; i >= 0; i--) {
                if(Character.isDigit(S.charAt(i))) {
                    digitCount++;
                    if(digitCount <= 4) sb.append(S.charAt(i));
                    else sb.append("*");

                    if(digitCount == 4 || digitCount == 7 || digitCount == 10) sb.append("-");
                }
            }
            if(digitCount > 10) sb.append("+");
            else sb.deleteCharAt(sb.length() - 1);

            return sb.reverse().toString();
        }
    }
}
