import java.util.ArrayList;

public class LC155_MinStack {
    ArrayList<Integer> data;
    ArrayList<Integer> mins;
    /** initialize your data structure here. */
    public LC155_MinStack() {
        data = new ArrayList<>();
        mins = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
        if(data.size()==1) mins.add(x);
        else if(x<=mins.get(mins.size()-1)) mins.add(x);
    }

    public void pop() {
        if(data.get(data.size() - 1).equals(mins.get(mins.size() - 1))){
            mins.remove(mins.size()-1);
        }
        data.remove(data.size()-1);
    }

    public int top() {
        return data.get(data.size()-1);
    }

    public int getMin() {
        return mins.get(mins.size()-1);
    }
}
