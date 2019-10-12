import java.util.*;

public class LC895_MaximumFrequencyStack {
    private Map<Integer, Integer> freq;
    private List<Stack<Integer>> stacks;

    public LC895_MaximumFrequencyStack() {
        freq = new HashMap<>();
        stacks = new ArrayList<>();
    }

    public void push(int x) {
        int cnt = freq.getOrDefault(x, 0) + 1;
        freq.put(x, cnt);

        if(stacks.size() < cnt) stacks.add(new Stack<>());
        stacks.get(cnt - 1).push(x);
    }

    public int pop() {
        int res = stacks.get(stacks.size() - 1).pop();
        if(stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        freq.put(res, freq.get(res) - 1);
        return res;
    }
}
