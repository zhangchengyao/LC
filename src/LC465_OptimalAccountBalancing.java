import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC465_OptimalAccountBalancing {
    int res = Integer.MAX_VALUE;
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] trans: transactions){
            map.put(trans[0], map.getOrDefault(trans[0], 0)-trans[2]);
            map.put(trans[1], map.getOrDefault(trans[1], 0)+trans[2]);
        }
        List<Integer> accounts = new ArrayList<>();
        for(int val: map.values()){
            if(val!=0) accounts.add(val);
        }
        helper(accounts, 0, 0);
        return res;
    }
    private void helper(List<Integer> accounts, int cnt, int start){
        while(start<accounts.size() && accounts.get(start)==0) start++;
        if(start>=accounts.size()){
            res = Math.min(res, cnt);
            return ;
        }
        int money = accounts.get(start);
        for(int i=start+1;i<accounts.size();i++){
            if(money*accounts.get(i)<0){
                accounts.set(i, accounts.get(i)+money);
                helper(accounts, cnt+1, start+1);
                accounts.set(i, accounts.get(i)-money);
            }
        }
    }
}
