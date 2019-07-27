import java.util.HashMap;

public class LC359_LoggerRateLimiter {
    private HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public LC359_LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message) || map.get(message) <= timestamp - 10){
            map.put(message, timestamp);
            return true;
        }
        else return false;
    }
}
