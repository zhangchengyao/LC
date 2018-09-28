import java.util.HashSet;

public class LC318_MaximumProductOfWordLengths {
    // use bit manipulation instead of hashmap
//    public int maxProduct(String[] words) {
//        int max = 0;
//        int mask = 0;
//        for(int i=0;i<words.length-1;i++){
//            mask = 0;
//            for(int k=0;k<words[i].length();k++) mask |= 1<<(words[i].charAt(k)-'a');
//            for(int j=i+1;j<words.length;j++){
//                int test = 0;
//                for(int t=0;t<words[j].length();t++){
//                    test |= 1<<(words[j].charAt(t)-'a');
//                }
//                if((mask&test)==0 && words[i].length()*words[j].length()>max) max = words[i].length()*words[j].length();
//            }
//        }
//        return max;
//    }
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
