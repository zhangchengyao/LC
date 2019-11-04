import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC658_FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int idx = Arrays.binarySearch(arr, x);
        if(idx < 0) idx = -idx - 1;
        int i = idx - 1;
        int j = idx;
        for(int cnt = 0; cnt < k; cnt++){
            if(i >= 0 && (j >= arr.length || x - arr[i] <= arr[j] - x)) res.add(0, arr[i--]);
            else res.add(arr[j++]);
        }
        return res;
    }
}
