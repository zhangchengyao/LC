public class LC838_PushDominoes {
    // difficult to think of
//    public String pushDominoes(String dominoes) {
//        int N = dominoes.length();
//        int[] forces = new int[N];
//        int force = 0;
//        for(int i = 0; i < N; i++) {
//            if(dominoes.charAt(i) == 'L') force = 0;
//            else if(dominoes.charAt(i) == 'R') force = N;
//            else force = Math.max(force - 1, 0);
//            forces[i] = force;
//        }
//
//        force = 0;
//        for(int i = N - 1; i >= 0; i--) {
//            if(dominoes.charAt(i) == 'L') force = N;
//            else if(dominoes.charAt(i) == 'R') force = 0;
//            else force = Math.max(force - 1, 0);
//            forces[i] -= force;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < N; i++) {
//            sb.append(forces[i] > 0 ? 'R' : (forces[i] == 0 ? '.' : 'L'));
//        }
//        return sb.toString();
//    }

    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int r = -1;
        int cur = 0;
        int idx = 0;
        while(cur < dominoes.length()) {
            if(dominoes.charAt(cur) == 'L') {
                if(r != -1) {
                    int len = cur - r;
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
                    sb.append("L".repeat(Math.max(0, cur - idx + 1)));
                }
                idx = cur + 1;
            } else if(dominoes.charAt(cur) == 'R') {
                if(r != -1) {
                    sb.append("R".repeat(Math.max(0, cur - r)));
                } else {
                    sb.append(".".repeat(Math.max(0, cur - idx)));
                }
                r = cur;
            }
            cur++;
        }

        if(r != -1) {
            sb.append("R".repeat(Math.max(0, cur - r)));
        } else {
            sb.append(".".repeat(Math.max(0, cur - idx)));
        }

        return sb.toString();
    }
}
