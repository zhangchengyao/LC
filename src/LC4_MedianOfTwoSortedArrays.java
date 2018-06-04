public class LC4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if((len1+len2)%2==0){
            return (findKth(nums1, nums2, 0, len1-1, 0, len2-1, (len1+len2)/2) +
                    findKth(nums1, nums2, 0, len1-1, 0, len2-1, (len1+len2)/2+1)) / 2.0;
        }else{
            return findKth(nums1, nums2, 0, len1-1, 0, len2-1, (len1+len2)/2+1);
        }
    }
    private double findKth(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k){
        if(start1>end1) return nums2[start2+k-1];
        if(start2>end2) return nums1[start1+k-1];
        if(k==1) return Math.min(nums1[start1], nums2[start2]);
        int p = k / 2;
        int q = k - p;
        if(p>end1-start1+1){
            q += p-(end1-start1+1);
            p = end1-start1+1;
        }
        if(q>end2-start2+1){
            p += q-(end2-start2+1);
            q = end2-start2+1;
        }
        if(nums1[start1+p-1]==nums2[start2+q-1]){
            return nums1[start1+p-1];
        }else if(nums1[start1+p-1]>nums2[start2+q-1]){
            return findKth(nums1, nums2, start1, start1+p-1, start2+q, end2, k-q);
        }else{
            return findKth(nums1, nums2, start1+p, end1, start2, start2+q-1, k-p);
        }
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
