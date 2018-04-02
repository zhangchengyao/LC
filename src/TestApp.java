public class TestApp {
    public static void main(String[] args){
        MergeSort mergeSort = new MergeSort(20);
        QuickSort quickSort = new QuickSort(20);
        for(int i=0;i<15;i++){
            long val = (long)(Math.random() * 100);
            mergeSort.insert(val);
            quickSort.insert(val);
        }
        mergeSort.display();
        mergeSort.sort();
        mergeSort.display();

        quickSort.display();
        quickSort.sort();
        quickSort.display();
    }
}
