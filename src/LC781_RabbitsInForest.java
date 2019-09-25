public class LC781_RabbitsInForest {
    public int numRabbits(int[] answers) {
        int[] groups = new int[1001];
        int res = 0;
        for(int rabbit: answers) {
            int size = rabbit + 1;
            if(groups[size] > 0) {
                groups[size]--;
            } else {
                res += size;
                groups[size] = size - 1;
            }
        }

        return res;
    }
}
