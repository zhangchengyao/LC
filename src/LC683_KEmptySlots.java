public class LC683_KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        int[] slots = new int[flowers.length]; // slots[i] denotes which day the flower at position i will bloom
        for(int i=0;i<flowers.length;i++){
            slots[flowers[i]-1] = i+1;
        }
        int min = Integer.MAX_VALUE;
        boolean find = false;
        for(int i=0;i<slots.length-k-1;i++){
            int day = Math.max(slots[i], slots[i+k+1]);
            int j = i+1;
            for(;j<i+k+1;j++){
                if(slots[j]<day) break;
            }
            if(j==i+k+1){
                find = true;
                min = Math.min(min, day);
            }
        }
        return find?min:-1;
    }
}
