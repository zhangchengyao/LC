package sort;

public class MergeSort {

    private long[] array;
    private int nElem;

    public MergeSort(int num){
        array = new long[num];
        nElem = 0;
    }

    public void insert(long val){
        array[nElem++] = val;
    }

    public void display(){
        for(int i=0;i<nElem;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void sort(){
        long[] workSpace = new long[nElem];
        mergeSort(workSpace, 0, nElem-1);
    }

    private void mergeSort(long[] workSpace, int low, int high){
        if(low==high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(workSpace, low, mid);
        mergeSort(workSpace, mid+1, high);
        merge(workSpace, low, mid, high);
    }

    private void merge(long[] workSpace, int low, int mid, int high){
        int index1 = low;
        int index2 = mid + 1;
        int j = 0;
        while(index1<=mid && index2<=high){
            if(array[index1]<array[index2]){
                workSpace[j++] = array[index1++];
            }else{
                workSpace[j++] = array[index2++];
            }
        }
        while(index1<=mid){
            workSpace[j++] = array[index1++];
        }
        while(index2<=high){
            workSpace[j++] = array[index2++];
        }

        for(int k=0;k<j;k++){
            array[low+k] = workSpace[k];
        }
    }
}
