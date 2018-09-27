import java.util.ArrayList;

public class LC384_ShuffleAnArray {
    int[] data;
    public LC384_ShuffleAnArray(int[] nums) {
        data = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return data;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[data.length];
        for(int i=0;i<data.length;i++) res[i] = data[i];
        for(int i=0;i<data.length;i++){
            int index = (int)(res.length*Math.random());
            int tmp = res[index];
            res[index] = res[i];
            res[i] = tmp;
        }
        return res;
    }
}
