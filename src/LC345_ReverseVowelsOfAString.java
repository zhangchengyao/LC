public class LC345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        StringBuilder res = new StringBuilder();
        int vo = s.length()-1;
        for(int i=0;i<s.length();i++){
            if(!isVowel(s.charAt(i))){
                res.append(s.charAt(i));
            }
            else{
                while(vo>=0 && !isVowel(s.charAt(vo))) vo--;
                res.append(s.charAt(vo--));
            }
        }
        return res.toString();
    }
    private boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
                || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}
