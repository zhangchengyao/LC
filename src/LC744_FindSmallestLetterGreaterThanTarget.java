public class LC744_FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int idx = binarySearch(letters, target);

        if(idx == letters.length) return letters[0];
        else return letters[idx];
    }

    private int binarySearch(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(letters[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
}
