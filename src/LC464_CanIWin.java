import java.util.HashMap;

public class LC464_CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal<=maxChoosableInteger) return true;
        if(desiredTotal>(maxChoosableInteger+1)*maxChoosableInteger/2) return false;
        char[] state = new char[maxChoosableInteger];
        for(int i=0;i<state.length;i++) state[i] = '0';
        return dfs(desiredTotal, state, new HashMap<String, Boolean>());
    }
    private boolean dfs(int desiredTotal, char[] state, HashMap<String, Boolean> map){
        String s = new String(state);
        if(map.containsKey(s)) return map.get(s);
        for(int i=0;i<state.length;i++){
            if(state[i]=='0'){
                state[i] = '1';
                if((i+1)>=desiredTotal || !dfs(desiredTotal-(i+1), state, map)){
                    state[i] = '0';
                    map.put(s, true);
                    return true;
                }
                state[i] = '0';
                map.put(s, false);
            }
        }
        return false;
    }
}
