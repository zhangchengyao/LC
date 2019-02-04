import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC599_MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> common = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }

        int min = list1.length + list2.length;
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                int sum = map.get(list2[i]) + i;
                if(sum < min){
                    common.clear();
                    common.add(list2[i]);
                    min = sum;
                } else if(sum == min){
                    common.add(list2[i]);
                }
            }
        }

        String[] res = new String[common.size()];
        for(int i = 0; i < common.size(); i++){
            res[i] = common.get(i);
        }

        return res;
    }
}
