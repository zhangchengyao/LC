public class LC926_FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        char[] arr = S.toCharArray();
        int[] zerosFromLeft = new int[arr.length];
        int[] zerosFromRight = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            if(i==0){
                if(arr[0]=='0'){
                    zerosFromLeft[i] = 1;
                }
            }
            else{
                zerosFromLeft[i] = arr[i]=='0'?zerosFromLeft[i-1]+1:zerosFromLeft[i-1];
            }
        }
        for(int i=arr.length-1;i>=0;i--){
            if(i==arr.length-1){
                if(arr[i]=='0'){
                    zerosFromRight[i] = 1;
                }
            }
            else{
                zerosFromRight[i] = arr[i]=='0'?zerosFromRight[i+1]+1:zerosFromRight[i+1];
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(i==0) res = Math.min(res, zerosFromRight[i+1]);
            else if(i==arr.length-1) res = Math.min(res, i-zerosFromLeft[i-1]);
            else res = Math.min(res, i-zerosFromLeft[i-1] + zerosFromRight[i+1]);
        }
        return res;
    }
}
