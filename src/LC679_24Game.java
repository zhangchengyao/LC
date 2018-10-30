import java.util.ArrayList;
import java.util.List;

public class LC679_24Game {
    double eps = 0.001;
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++) list.add(nums[i]*1.0);
        return judge(list);
    }
    private boolean judge(List<Double> list){
        if(list.size()==1) return Math.abs(list.get(0)-24.0)<eps;
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                double a = list.get(i);
                double b = list.get(j);
                list.remove(j);
                list.remove(i);

                list.add(a+b);
                if(judge(new ArrayList<>(list))) return true;
                list.remove((a+b));
                list.add(a-b);
                if(judge(new ArrayList<>(list))) return true;
                list.remove((a-b));
                list.add(b-a);
                if(judge(new ArrayList<>(list))) return true;
                list.remove((b-a));
                list.add(a*b);
                if(judge(new ArrayList<>(list))) return true;
                list.remove((a*b));
                if(b!=0){
                    list.add(a/b);
                    if(judge(new ArrayList<>(list))) return true;
                    list.remove((a/b));
                }
                if(a!=0){
                    list.add(b/a);
                    if(judge(new ArrayList<>(list))) return true;
                    list.remove((b/a));
                }

                list.add(i, a);
                list.add(j, b);
            }
        }
        return false;
    }
}
