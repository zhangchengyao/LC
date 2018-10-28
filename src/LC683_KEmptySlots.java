public class LC683_KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        int[] slots = new int[flowers.length]; // slots[i] denotes which day the flower at position i will bloom
        for(int i=0;i<flowers.length;i++){
            slots[flowers[i]-1] = i+1;
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = left+k+1;
        int i = left + 1;
        while(right<slots.length){
            if(i==right){
                min = Math.min(min, Math.max(slots[left], slots[right]));
                left++;
                right++;
                i = left+1;
            }
            else{
                if(slots[i]<Math.max(slots[left], slots[right])){
                    left = i;
                    right = left+k+1;
                }
                i++;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
