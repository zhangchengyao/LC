import java.util.ArrayList;
import java.util.List;

public class LC751_IPToCIDR {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> res = new ArrayList<>();

        long ipVal = 0;
        for(String part: ip.split("\\.")) {
            ipVal = Integer.parseInt(part) + ipVal * 256;
        }

        while(n > 0) {
            long step = ipVal & -ipVal;

            while(step > n) step >>>= 1;

            res.add(constructCIDR(ipVal, step));

            n -= step;
            ipVal += step;
        }

        return res;
    }

    private String constructCIDR(long x, long step) {
        int prefix = 32;
        int[] nums = new int[4];
        for(int i = 0; i < 4; i++) {
            nums[3 - i] = (int)(x >>> (8 * i)) & 255;
        }
        while((step & 1) != 1) {
            prefix--;
            step >>>= 1;
        }

        return String.format("%d.%d.%d.%d/%d", nums[0], nums[1], nums[2], nums[3], prefix);
    }
}
