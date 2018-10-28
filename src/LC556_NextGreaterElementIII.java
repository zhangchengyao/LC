public class LC556_NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        String sn = n+"";
        char[] arr = sn.toCharArray();
        StringBuilder res = new StringBuilder();
        int i = arr.length-2;
        int j = arr.length-1;
        while(i>=0){
            if(arr[i]<arr[i+1]){
                while(arr[j]<=arr[i]) j--;
                char c = arr[j];
                arr[j] = arr[i];
                arr[i] = c;
                break;
            }
            i--;
        }
        if(i<0) return -1;
        res.append(sn.substring(0, i)).append(arr[i]);
        for(int p=arr.length-1;p>i;p--) res.append(arr[p]);
        long great = Long.parseLong(res.toString());
        return great>Integer.MAX_VALUE?-1:(int)great;
    }
}
