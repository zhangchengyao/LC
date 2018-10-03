public class LC388_LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int max = 0;
        String[] paths = input.split("\n");
        for(int i=paths.length-1;i>=0;i--){
            if(paths[i].indexOf('.')!=-1){
                int lv = paths[i].lastIndexOf('\t');
                int len = paths[i].substring(lv+1).length();
                for(int j=i-1;j>=0;j--){
                    if(paths[j].lastIndexOf('\t')==lv-1){
                        len += paths[j].substring(lv).length()+1;
                        lv--;
                    }
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
