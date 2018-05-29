import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                res.add(nums1[i]);
                while(++i<nums1.length && nums1[i]==res.get(res.size()-1)){}
                while(++j<nums2.length && nums2[j]==res.get(res.size()-1)){}
            }else if(nums1[i]>nums2[j]){
                while(++j<nums2.length && nums2[j]<nums1[i]){}
            }else{
                while(++i<nums1.length && nums1[i]<nums2[j]){}
            }
        }
        int[] resArray = new int[res.size()];
        for(i=0;i<res.size();i++){
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
