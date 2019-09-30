public class LC810_ChalkboardXORGame {
    // when there are even number of elements, Alice must have a possible move to win
    // proven by contradiction
    public boolean xorGame(int[] nums) {
        int x = 0;
        for(int num: nums) x ^= num;

        return x == 0 || nums.length % 2 == 0;
    }
}
