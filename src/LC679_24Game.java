public class LC679_24Game {
    private double eps = 1e-4;

    public boolean judgePoint24(int[] nums) {
        double[] numbers = new double[nums.length];
        for(int i = 0; i < nums.length; i++) numbers[i] = nums[i];

        return judge24(numbers);
    }

    private boolean judge24(double[] nums) {
        if(nums[1] == Integer.MIN_VALUE && nums[2] == Integer.MIN_VALUE && nums[3] == Integer.MIN_VALUE) return Math.abs(nums[0] - 24) < eps;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == Integer.MIN_VALUE) continue;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] == Integer.MIN_VALUE) continue;
                double a = nums[i];
                double b = nums[j];

                nums[i] = a + b;
                nums[j] = Integer.MIN_VALUE;
                if(judge24(nums)) return true;

                nums[i] = a - b;
                if(judge24(nums)) return true;

                nums[i] = b - a;
                if(judge24(nums)) return true;

                nums[i] = a * b;
                if(judge24(nums)) return true;

                if(b != 0) {
                    nums[i] = a / b;
                    if(judge24(nums)) return true;
                }

                if(a != 0) {
                    nums[i] = b / a;
                    if(judge24(nums)) return true;
                }

                nums[i] = a;
                nums[j] = b;
            }
        }

        return false;
    }
}
