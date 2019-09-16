public class LC622_DesignCircularQueue {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public LC622_DesignCircularQueue(int k) {
        data = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size < data.length) {
            rear = (rear + 1) % data.length;
            data[rear] = value;
            size++;
            return true;
        }

        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size > 0) {
            front = (front + 1) % data.length;
            size--;
            return true;
        }

        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return size == 0 ? -1 : data[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return size == 0 ? -1 : data[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == data.length;
    }
}
