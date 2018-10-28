public class LC167_TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int right = numbers.length-1;
        int left = 0;
        int sum;
        while((sum=numbers[left]+numbers[right])!=target){
            if(sum>target) right--;
            else left++;
        }
        res[0] = left + 1;
        res[1] = right + 1;
        return res;
    }
}
