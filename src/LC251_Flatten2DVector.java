import java.util.List;

public class LC251_Flatten2DVector {
    private List<List<Integer>> vec;
    private int inner;
    private int outer;
    public LC251_Flatten2DVector(List<List<Integer>> vec2d) {
        vec = vec2d;
        inner = 0;
        outer = 0;
    }

    public Integer next() {
        int res = vec.get(outer).get(inner++);
        while(outer!=vec.size() && inner==vec.get(outer).size()){
            outer++;
            inner = 0;
        }
        return res;
    }

    public boolean hasNext() {
        while(outer!=vec.size() && inner==vec.get(outer).size()){
            outer++;
            inner = 0;
        }
        return outer!=vec.size() && inner!=vec.get(outer).size();
    }
}
