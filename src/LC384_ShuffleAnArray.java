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
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<data.length;i++){
            list.add(data[i]);
        }
        int[] res = new int[data.length];
        for(int i=0;i<data.length;i++){
            int index = (int)(list.size()*Math.random());
            res[i] = list.get(index);
            list.remove(index);
        }
        return res;
    }
}
