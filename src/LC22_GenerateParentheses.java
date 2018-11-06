import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res =  new ArrayList<>();
        generateRec(n, 0, "", res);
        return res;
    }
    private void generateRec(int n, int numOpen, String tmp, List<String> res){
        if(tmp.length()==(n<<1)){
            res.add(tmp);
            return;
        }
        if(numOpen==n) generateRec(n, numOpen, tmp+")", res);
        else{
            generateRec(n, numOpen+1, tmp+"(", res);
            int numClose = tmp.length()-numOpen;
            if(numClose<numOpen) generateRec(n, numOpen, tmp+")", res);
        }
    }
}
