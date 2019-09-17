import java.util.ArrayList;
import java.util.List;

public class LC638_ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price, special, needs, 0);
    }

    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int start) {
        if(price.size() == 0 || special.size() == 0 || needs.size() == 0) return 0;

        int curPrice = 0;
        for(int i = 0; i < price.size(); i++) {
            curPrice += needs.get(i) * price.get(i);
        }

        for(int i = start; i < special.size(); i++) {
            List<Integer> sp = special.get(i);
            List<Integer> copy = new ArrayList<>(needs);
            int k = 0;
            for(; k < needs.size(); k++) {
                if(copy.get(k) >= sp.get(k)) {
                    copy.set(k, copy.get(k) - sp.get(k));
                } else {
                    break;
                }
            }
            if(k == needs.size()) {
                curPrice = Math.min(curPrice, sp.get(k) + helper(price, special, copy, i));
            }
        }

        return curPrice;
    }
}
