import java.util.HashMap;

public class LC904_FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> index = new HashMap<>();
        int start = 0;
        int p = 0;
        int res = -1;
        while(p<tree.length){
            if(!index.containsKey(tree[p])){
                if(index.size()<2) index.put(tree[p], p);
                else{
                    res = Math.max(res, p-start);
                    int type1 = -1;
                    int type2 = -1;
                    for(int it: index.keySet()){
                        if(type1==-1) type1 = it;
                        else type2 = it;
                    }
                    if(index.get(type1)<index.get(type2)){
                        start = index.get(type1)+1;
                        index.remove(type1);
                    }else{
                        start = index.get(type2)+1;
                        index.remove(type2);
                    }
                    index.put(tree[p], p);
                }
            }
            else{
                index.put(tree[p], p);
            }
            p++;
        }
        res = Math.max(res, p-start);
        return res;
    }
}
