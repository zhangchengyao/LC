public class LC1151_MinimumSwapsToGroupAll1sTogether {
    public int minSwaps(int[] data) {
        int numOfOnes = 0;
        for(int num: data) {
            if(num == 1) numOfOnes++;
        }
        if(numOfOnes <= 1) return 0;

        int maxOne = 0;
        int curOne = 0;
        int i = 0;
        int j = 0;
        while(j < data.length) {
            if(data[j++] == 1) {
                curOne++;
            }
            maxOne = Math.max(maxOne, curOne);
            if(j - i >= numOfOnes) {
                if(data[i++] == 1) curOne--;
            }
        }

        return numOfOnes - maxOne;
    }
}
