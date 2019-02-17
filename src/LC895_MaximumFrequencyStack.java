import java.util.HashMap;
import java.util.Stack;

public class LC895_MaximumFrequencyStack {
    private HashMap<Integer, Integer> count;
    private HashMap<Integer, Stack<Integer>> freq2Stack;
    private int maxFreq;

    public LC895_MaximumFrequencyStack() {
        count = new HashMap<>();
        freq2Stack = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        count.put(x, count.getOrDefault(x, 0) + 1);
        if(count.get(x) > maxFreq){
            maxFreq = count.get(x);
        }
        freq2Stack.putIfAbsent(count.get(x), new Stack<>());
        freq2Stack.get(count.get(x)).push(x);
    }

    public int pop() {
        int num = freq2Stack.get(maxFreq).pop();
        if(freq2Stack.get(maxFreq).isEmpty()){
            freq2Stack.remove(maxFreq);
            maxFreq--;
        }

        count.put(num, count.get(num) - 1);
        if(count.get(num) == 0) count.remove(num);
        return num;
    }
}
