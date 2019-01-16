public class LC440_KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int num = 1;
        int numSubNodes = countSubNode(n, num);
        while(k>1){
            if(k>numSubNodes){
                k -= numSubNodes;
                num++;
            }
            else {
                num *= 10;
                k--;
            }
            numSubNodes = countSubNode(n, num);
        }
        return num;
    }

    private int countSubNode(int n, int d){
        int cnt = 0;

        long start = d;
        long end = d+1;
        while(start<=n){
            cnt += Math.min(n+1, end) - start;
            start *= 10;
            end *= 10;
        }
        return cnt;
    }
}
