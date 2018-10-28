public class LC165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        int i = 0;
        int j = 0;
        while(i<v1.length && j<v2.length){
            int k = i+1;
            while(k<v1.length && v1[k]!='.') k++;
            int t = j+1;
            while(t<v2.length && v2[t]!='.') t++;
            if(Integer.parseInt(version1.substring(i, k))>Integer.parseInt(version2.substring(j, t))) return 1;
            else if(Integer.parseInt(version1.substring(i, k))<Integer.parseInt(version2.substring(j, t))) return -1;
            i = k+1;
            j = t+1;
        }
        if(i>=v1.length && j>=v2.length) return 0;
        else if(i>=v1.length){
            while(j<v2.length){
                if(v2[j]=='0'||v2[j]=='.') j++;
                else break;
            }
            return j==v2.length?0:-1;
        }
        else{
            while(i<v1.length){
                if(v1[i]=='0'||v1[i]=='.') i++;
                else break;
            }
            return i==v1.length?0:1;
        }
    }
}
