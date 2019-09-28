import java.util.ArrayList;
import java.util.List;

public class LC822_CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {
        List<Integer> goodCards = new ArrayList<>();
        boolean[] badNums = new boolean[2001];

        for(int i = 0; i < fronts.length; i++) {
            if(fronts[i] != backs[i]) {
                goodCards.add(i);
            } else {
                badNums[fronts[i]] = true;
            }
        }

        int smallest = 2001;
        for(int card: goodCards) {
            if(!badNums[fronts[card]]) {
                smallest = Math.min(smallest, fronts[card]);
            }
            if(!badNums[backs[card]]) {
                smallest = Math.min(smallest, backs[card]);
            }
        }

        return smallest == 2001 ? 0 : smallest;
    }
}
