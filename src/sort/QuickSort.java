package sort;

public class QuickSort {
    private long[] array;
    private int nElems;

    public QuickSort(int num){
        array = new long[num];
        nElems = 0;
    }

    public void insert(long val){
        array[nElems++] = val;
    }

    public void display(){
        for(int i=0;i<nElems;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void sort(){
        quickSort(0, nElems-1);
    }

    private void quickSort(int left, int right){
        if(right-left<10){
            insertionSort(left, right);
        }else{
            long pivot = median3(left, right);
            int leftPtr = left;
            int rightPtr = right - 1;
            while(true){
                while(array[++leftPtr]<pivot){ }
                while(array[--rightPtr]>pivot){ }
                if(leftPtr>=rightPtr){
                    break;
                }
                swap(leftPtr, rightPtr);
            }
            swap(leftPtr, right-1);
            quickSort(left, leftPtr-1);
            quickSort(leftPtr+1, right);
        }
    }

    private long median3(int left, int right){
        int middle = (left + right) / 2;
        if(array[left] > array[middle]){
            swap(left, middle);
        }
        if(array[left] > array[right]){
            swap(left, right);
        }
        if(array[middle] > array[right]){
            swap(middle, right);
        }
        swap(middle, right-1);
        return array[right-1];
    }

    private void insertionSort(int left, int right){
        for(int out=left+1; out<=right; out++){
            int in = out;
            long temp = array[out];
            while(in>0 && array[in-1]>temp){
                array[in] = array[in-1];
                in--;
            }
            array[in] = temp;
        }
    }

    private void swap(int index1, int index2){
        long temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
