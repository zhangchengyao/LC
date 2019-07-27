public class LC360_SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(a == 0) return solveLinear(nums, b, c);

        int[] res = new int[nums.length];
        double sym = -b / (2.0 * a);
        int i = 0;
        int j = nums.length - 1;
        if(a > 0) {
            int idx = nums.length - 1;
            while(i <= j) {
                if(Math.abs(nums[i] - sym) >= Math.abs(nums[j] - sym)) {
                    res[idx--] = f(nums[i++], a, b, c);
                } else {
                    res[idx--] = f(nums[j--], a, b, c);
                }
            }
        } else {
            int idx = 0;
            while(i <= j) {
                if(Math.abs(nums[i] - sym) >= Math.abs(nums[j] - sym)) {
                    res[idx++] = f(nums[i++], a, b, c);
                } else {
                    res[idx++] = f(nums[j--], a, b, c);
                }
            }
        }
        return res;
    }

    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    private int[] solveLinear(int[] nums, int b, int c) {
        int[] res = new int[nums.length];
        if(b > 0) {
            for(int i = 0; i < nums.length; i++) {
                res[i] = b * nums[i] + c;
            }
        } else {
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                res[i] = b * nums[n - 1 - i] + c;
            }
        }

        return res;
    }
}
