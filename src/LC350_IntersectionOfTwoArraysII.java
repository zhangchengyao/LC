import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC350_IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                while(++i<nums1.length && nums1[i]<nums2[j]){}
            }else{
                while(++j<nums2.length && nums2[j]<nums1[i]){}
            }
        }
        int[] resArray = new int[res.size()];
        for(i=0;i<res.size();i++){
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
