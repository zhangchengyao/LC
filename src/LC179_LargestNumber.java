import java.util.Arrays;
import java.util.Comparator;

public class LC179_LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, (a,b)->(b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for(String str: numsStr){
            sb.append(str);
        }

        if(sb.charAt(0)=='0') return "0";
        return sb.toString();
    }
}
