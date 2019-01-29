package amazon;

import java.util.HashSet;

public class Number_Substrings_K_Distinct_Characters {
    public static int countKDistinct(String str, int k){
        if(k==0) return 0;

        int cnt = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            set.clear();
            for(int j=i;j<str.length();j++){
                set.add(str.charAt(j));
                if(set.size()==k) cnt++;
                else if(set.size()>k) break;
            }
        }

        return cnt;
    }

    public static void main(String[] args)
    {
        String ch = "abcbaa";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                k +    " distinct characters : "
                + countKDistinct(ch, k));
    }
}
