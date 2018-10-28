public class LC4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int totalLen = nums1.length + nums2.length;
        return (findKth(nums1, 0, nums2, 0, (totalLen+1)/2) + findKth(nums1, 0, nums2, 0, (totalLen+2)/2))/2;
    }
    private double findKth(int[] nums1, int start1, int[] nums2, int start2, int k){
        if(start1>=nums1.length) return nums2[start2+k-1];
        if(start2>=nums2.length) return nums1[start1+k-1];
        if(k==1) return Math.min(nums1[start1], nums2[start2]);
        int find1 = start1+k/2-1>=nums1.length?Integer.MAX_VALUE:nums1[start1+k/2-1];
        int find2 = start2+k-k/2-1>=nums2.length?Integer.MAX_VALUE:nums2[start2+k-k/2-1];
        if(find1<find2) return findKth(nums1, start1+k/2, nums2, start2, k-k/2);
        else return findKth(nums1, start1, nums2, start2+k-k/2, k/2);
    }
    // O(m+n) solution
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] arr = new int[nums1.length+nums2.length];
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        while(i<nums1.length && j<nums2.length){
//            if(nums1[i]<=nums2[j]){
//                arr[k++] = nums1[i++];
//            }else{
//                arr[k++] = nums2[j++];
//            }
//        }
//        if(i==nums1.length){
//            while(j<nums2.length){
//                arr[k++] = nums2[j++];
//            }
//        }else{
//            while(i<nums1.length){
//                arr[k++] = nums1[i++];
//            }
//        }
//        if(arr.length%2==0){
//            return (arr[(arr.length-1)/2]+arr[arr.length/2])/2.0;
//        }else{
//            return arr[(arr.length-1)/2];
//        }
//    }
}
