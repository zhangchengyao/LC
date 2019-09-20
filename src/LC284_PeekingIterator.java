import java.util.Iterator;

public class LC284_PeekingIterator {
    private Integer buffer;
    private Iterator<Integer> iterator;

    public LC284_PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        buffer = null;
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(buffer == null) {
            buffer = iterator.next();
        }
        return buffer;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {
        if(buffer == null) {
            return iterator.next();
        } else {
            Integer res = buffer;
            buffer = null;
            return res;
        }
    }

    public boolean hasNext() {
        return buffer != null || iterator.hasNext();
    }
}
