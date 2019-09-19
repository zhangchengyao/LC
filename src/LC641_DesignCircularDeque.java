public class LC641_DesignCircularDeque {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LC641_DesignCircularDeque(int k) {
        data = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size == data.length) return false;

        if(rear == -1) {
            rear++;
        } else {
            front = (front + data.length - 1) % data.length;
        }
        data[front] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == data.length) return false;

        rear = (rear + 1) % data.length;
        data[rear] = value;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0) return false;

        front = (front + 1) % data.length;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0) return false;

        rear = (rear + data.length - 1) % data.length;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return size == 0 ? -1 : data[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return size == 0 ? -1 : data[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == data.length;
    }
}
