import java.util.ArrayList;
import java.util.List;

public class LC352_DataStreamAsDisjointIntervals {
    class Interval {
        int start;
        int end;
        Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    private List<Interval> intervals;

    /** Initialize your data structure here. */
    public LC352_DataStreamAsDisjointIntervals() {
        intervals = new ArrayList<>();
    }

    public void addNum(int val) {
        int idx = binarySearch(val);
        if(idx > 0) {
            if(val <= intervals.get(idx - 1).end) return;

            if(val - 1 == intervals.get(idx - 1).end) {
                intervals.get(idx - 1).end = val;
                if(idx < intervals.size() && val + 1 == intervals.get(idx).start) {
                    intervals.get(idx - 1).end = intervals.get(idx).end;
                    intervals.remove(idx);
                }
            } else {
                if(idx < intervals.size() && val + 1 == intervals.get(idx).start) {
                    intervals.get(idx).start = val;
                } else {
                    intervals.add(idx, new Interval(val, val));
                }
            }
        } else {
            if(idx < intervals.size() && val + 1 == intervals.get(idx).start) {
                intervals.get(idx).start = val;
            } else {
                intervals.add(idx, new Interval(val, val));
            }
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[intervals.size()][2];
        int i = 0;
        for(Interval it: intervals) {
            res[i][0] = it.start;
            res[i++][1] = it.end;
        }

        return res;
    }

    private int binarySearch(int val) {
        int left = 0;
        int right = intervals.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(intervals.get(mid).start > val) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
