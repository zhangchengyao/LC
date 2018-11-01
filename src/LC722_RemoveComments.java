import java.util.ArrayList;
import java.util.List;

public class LC722_RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean block = false;
        StringBuilder sb = new StringBuilder();
        for(String src: source){
            for(int i=0;i<src.length();i++){
                if(block){
                    if(i<src.length()-1 && src.substring(i, i+2).equals("*/")){
                        block = false;
                        i++;
                    }
                }
                else{
                    if(i<src.length()-1 && src.substring(i, i+2).equals("//")){
                        break;
                    }
                    else if(i<src.length()-1 && src.substring(i, i+2).equals("/*")){
                        block = true;
                        i++;
                    }
                    else{
                        sb.append(src.charAt(i));
                    }
                }
            }
            if(!block && sb.length()>0){
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
