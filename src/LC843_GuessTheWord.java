import java.util.ArrayList;

public class LC843_GuessTheWord {
    interface Master {
        public int guess(String word);
    }
    public void findSecretWord(String[] wordlist, Master master) {
        ArrayList<String> list = new ArrayList<>();
        for(String str: wordlist) list.add(str);
        for(int k=0;k<10;k++){
            if(list.isEmpty()) break;
            int idx = (int)(Math.random()*list.size());
            String selected = list.get(idx);
            int match = master.guess(selected);
            if(match==6) break;
            for(int i=0;i<list.size();i++){
                if(list.get(i).equals(selected) || similar(selected, list.get(i))!=match){
                    list.remove(i);
                    i--;
                }
            }
        }
    }
    private int similar(String word1, String word2){
        int cnt = 0;
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)==word2.charAt(i)) cnt++;
        }
        return cnt;
    }
}
