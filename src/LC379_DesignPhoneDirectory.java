import java.util.HashSet;

public class LC379_DesignPhoneDirectory {
    private HashSet<Integer> available;
    private HashSet<Integer> assigned;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public LC379_DesignPhoneDirectory(int maxNumbers) {
        available = new HashSet<>();
        for(int i = 0; i < maxNumbers; i++) {
            available.add(i);
        }
        assigned = new HashSet<>();
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(available.isEmpty()) return -1;

        int num = available.iterator().next();
        available.remove(num);
        assigned.add(num);

        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return available.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(number >= available.size() + assigned.size()) return ;
        assigned.remove(number);
        available.add(number);
    }
}
