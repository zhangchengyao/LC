public class LC702_SearchInASortedArrayOfUnknownSize {
    interface ArrayReader {
        int get(int idx);
    }

    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int val = reader.get(mid);
            if(val == target) return mid;
            else if(val > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
