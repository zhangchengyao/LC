public class LC71_SimplifyPath {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=tokens.length-1;i>=0;i--){
            if(tokens[i].equals("..")){
                cnt++;
            } else if(!(tokens[i].equals(".") || tokens[i].equals(""))){
                if(cnt>0) cnt--;
                else sb.insert(0, "/"+tokens[i]);
            }
        }

        if(sb.length()==0) return "/";
        else return sb.toString();
    }
}
