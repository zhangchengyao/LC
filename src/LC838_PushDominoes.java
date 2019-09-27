public class LC838_PushDominoes {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int r = -1;
        int l = 0;
        int idx = 0;
        while(l < dominoes.length()) {
            if(dominoes.charAt(l) == 'L') {
                if(r != -1) {
                    int len = l - r;
                    if((len & 1) == 0) {
                        sb.append("R".repeat(Math.max(0, len / 2)));
                        sb.append(".");
                        sb.append("L".repeat(Math.max(0, len / 2)));
                    } else {
                        sb.append("R".repeat(Math.max(0, len / 2 + 1)));
                        sb.append("L".repeat(Math.max(0, len / 2 + 1)));
                    }
                    r = -1;
                } else {
                    sb.append("L".repeat(Math.max(0, l - idx + 1)));
                }
                idx = l + 1;
            } else if(dominoes.charAt(l) == 'R') {
                if(r != -1) {
                    sb.append("R".repeat(Math.max(0, l - r)));
                } else {
                    sb.append(".".repeat(Math.max(0, l - idx)));
                }
                r = l;
            }
            l++;
        }

        if(r != -1) {
            sb.append("R".repeat(Math.max(0, l - r)));
        } else {
            sb.append(".".repeat(Math.max(0, l - idx)));
        }

        return sb.toString();
    }
}
