import java.util.HashSet;

public class LC318_MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<words.length-1;i++){
            set.clear();
            for(int k=0;k<words[i].length();k++) set.add(words[i].charAt(k));
            for(int j=i+1;j<words.length;j++){
                boolean valid = true;
                for(int t=0;t<words[j].length();t++){
                    if(set.contains(words[j].charAt(t))){
                        valid = false;
                        break;
                    }
                }
                if(valid && words[i].length()*words[j].length()>max) max = words[i].length()*words[j].length();
            }
        }
        return max;
    }
}
