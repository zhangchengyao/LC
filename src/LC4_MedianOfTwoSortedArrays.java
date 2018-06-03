public class LC4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                arr[k++] = nums1[i++];
            }else{
                arr[k++] = nums2[j++];
            }
        }
        if(i==nums1.length){
            while(j<nums2.length){
                arr[k++] = nums2[j++];
            }
        }else{
            while(i<nums1.length){
                arr[k++] = nums1[i++];
            }
        }
        if(arr.length%2==0){
            return (arr[(arr.length-1)/2]+arr[arr.length/2])/2.0;
        }else{
            return arr[(arr.length-1)/2];
        }
    }
}
