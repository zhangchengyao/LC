public class LC900_RLEIterator {
    int[] data;
    int index;
    int remaining;
    public LC900_RLEIterator(int[] A) {
        data = new int[A.length];
        for(int i=0;i<A.length;i++) data[i] = A[i];
        index = 0;
        remaining = data[0];
    }

    public int next(int n) {
        if(index>=data.length) return -1;
        while(remaining<n){
            n -= remaining;
            index += 2;
            if(index>=data.length) return -1;
            remaining = data[index];
        }
        remaining -= n;
        return data[index+1];
    }
}
