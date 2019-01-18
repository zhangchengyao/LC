public class LC466_CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(n1==0) return 0;

        int[] s2Cnt = new int[n1];
        int[] nextIdx = new int[n1];

        int idx2 = 0;
        int cnt = 0;
        for(int k=0;k<n1;k++){
            for(int i=0;i<s1.length();i++){
                if(s1.charAt(i)==s2.charAt(idx2)){
                    idx2++;
                    if(idx2==s2.length()){
                        cnt++;
                        idx2 = 0;
                    }
                }
            }

            s2Cnt[k] = cnt;
            nextIdx[k] = idx2;

            for(int start=0;start<k;start++){
                if(nextIdx[start]==nextIdx[k]){
                    int patternLen = k - start;
                    int numRepeat = s2Cnt[k] - s2Cnt[start];
                    int numPatterns = (n1-start-1) / patternLen;
                    int cntOfPatterns = numPatterns * numRepeat;
                    int remain = s2Cnt[start+(n1-start-1) % patternLen];
                    return (cntOfPatterns+remain) / n2;
                }
            }
        }

        return s2Cnt[n1-1] / n2;
    }
}
