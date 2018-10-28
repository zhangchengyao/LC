import java.util.HashMap;

public class LC299_BullsAndCows {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr1 = secret.toCharArray();
        char[] arr2 = guess.toCharArray();
        for(char c: arr1) map.put(c, map.getOrDefault(c, 0)+1);
        int A = 0;
        int B = 0;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]==arr2[i]) A++;
            if(map.containsKey(arr2[i]) && map.get(arr2[i])>0){
                map.put(arr2[i], map.get(arr2[i])-1);
                B++;
            }
        }
        return A+"A"+(B-A)+"B";
    }
}
